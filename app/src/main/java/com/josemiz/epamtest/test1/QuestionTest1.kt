package com.josemiz.epamtest.test1

object Question1Test {

    fun combineOutputs(priorityResult: CustomResult, secondaryResult: CustomResult): CustomResult {
        return when {
            priorityResult is CustomResult.RSuccess && secondaryResult is CustomResult.RSuccess -> {
                if (priorityResult.product.id == secondaryResult.product.id) {
                    priorityResult.apply {
                        product = product.copy(
                            amount = product.amount + secondaryResult.product.amount,
                            providers = product.providers.toMutableList()
                                .apply { addAll(secondaryResult.product.providers) }
                        )
                    }
                } else {
                    priorityResult
                }
            }

            else -> {
                CustomResult.RCriticalError
            }
        }
    }

    fun combineOutputsSimplified(priorityResult: CustomResult, secondaryResult: CustomResult) = when {
        priorityResult is CustomResult.RSuccess && secondaryResult is CustomResult.RSuccess -> {
            priorityResult.apply {
                if (product.id == secondaryResult.product.id) {
                    product = product.copy(
                        amount = product.amount + secondaryResult.product.amount,
                        providers = product.providers.toMutableList()
                            .apply { addAll(secondaryResult.product.providers) }
                    )
                }
            }
        }

        else -> CustomResult.RCriticalError
    }

    infix fun CustomResult.combineWith(secondaryResult: CustomResult): CustomResult {
        return combineOutputsSimplified(this, secondaryResult)
    }
}
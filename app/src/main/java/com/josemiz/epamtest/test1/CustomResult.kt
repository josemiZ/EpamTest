package com.josemiz.epamtest.test1

sealed class CustomResult {
    data class RSuccess(var product: ProductData) : CustomResult()
    data object RCriticalError : CustomResult()
}
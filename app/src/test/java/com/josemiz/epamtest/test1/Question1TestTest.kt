package com.josemiz.epamtest.test1

import com.josemiz.epamtest.test1.Question1Test.combineWith
import org.junit.Assert.assertEquals
import org.junit.Test

class Question1TestTest {

    private val priority = CustomResult.RSuccess(ProductData("1", 23, listOf("Pantene")))
    private val secondary = CustomResult.RSuccess(ProductData("1", 12, listOf("Dove")))
    private val error = CustomResult.RCriticalError

    @Test
    fun `combine outputs success merge`() {
        val customResult = Question1Test.combineOutputs(priority, secondary)
        assert(customResult is CustomResult.RSuccess)
        val successResult = customResult as CustomResult.RSuccess
        assertEquals(35, successResult.product.amount)
        assertEquals(listOf("Pantene", "Dove"), successResult.product.providers)
    }

    @Test
    fun `combine outputs success priority`() {
        val customResult = Question1Test.combineOutputs(
            priority,
            secondary.apply { product = product.copy(id = "2") })
        assert(customResult is CustomResult.RSuccess)
        assertEquals(priority, customResult)
    }

    @Test
    fun combineOutputsError() {
        val customResult = Question1Test.combineOutputs(error, secondary)
        assert(customResult is CustomResult.RCriticalError)
    }

    @Test
    fun combineOutputsSimplifiedSuccessMerge() {
        val customResult = Question1Test.combineOutputsSimplified(priority, secondary)
        assert(customResult is CustomResult.RSuccess)
        val successResult = customResult as CustomResult.RSuccess
        assertEquals(35, successResult.product.amount)
        assertEquals(listOf("Pantene", "Dove"), successResult.product.providers)
    }

    @Test
    fun combineOutputsSimplifiedSuccessPriority() {
        val customResult =
            Question1Test.combineOutputsSimplified(
                priority,
                secondary.apply { product = product.copy(id = "2") })
        assert(customResult is CustomResult.RSuccess)
        assertEquals(priority, customResult)
    }

    @Test
    fun combineOutputsSimplifiedError() {
        val customResult = Question1Test.combineOutputsSimplified(error, secondary)
        assert(customResult is CustomResult.RCriticalError)
    }

    @Test
    fun combineWithInfixSuccessMerge() {
        val customResult = priority combineWith secondary
        assert(customResult is CustomResult.RSuccess)
        val successResult = customResult as CustomResult.RSuccess
        assertEquals(35, successResult.product.amount)
        assertEquals(listOf("Pantene", "Dove"), successResult.product.providers)
    }
}
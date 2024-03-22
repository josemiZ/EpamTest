package com.josemiz.epamtest.test4

import com.josemiz.epamtest.argumentCaptor
import com.josemiz.epamtest.capture
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.`when`


class QuestionTest4Test {

    @Test
    fun `test combined let`() {
        val questionTest4 = QuestionTest4()
        questionTest4.combinedLet(1, 2) { first, second ->
            assertEquals(first, 1)
            assertEquals(second, 2)
        }
    }
}
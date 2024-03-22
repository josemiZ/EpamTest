package com.josemiz.epamtest.test4

open class QuestionTest4 {

    fun <T> combinedLet(first: T?, second: T?, action: (T,T) -> Unit) {
        if (first != null && second != null) action.invoke(first, second)
    }
}
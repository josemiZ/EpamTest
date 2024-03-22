package com.josemiz.epamtest.test2

import org.junit.Assert.assertEquals
import org.junit.Test

class Question2TestTest {

    private val movieCommunity = Movie("a", "Community")
    private val movieDunkirk = Movie("b", "Dunkirk")
    private val platform1 = Platform("a", true, false)
    private val movies1 = listOf(movieCommunity)
    private val movies2 = listOf(movieDunkirk)
    private val platforms = listOf(platform1)

    @Test
    fun `test get movies in platforms result not empty`(){
        val result = QuestionTest2.getMoviesInPlatforms(movies1, platforms)
        assertEquals(true, result.isNotEmpty())
        assertEquals(1, result.size)
        assertEquals("a", result[0].movieId)
        assertEquals("Community", result[0].title)
    }

    @Test
    fun `test get movies in platforms result empty`(){
        val result = QuestionTest2.getMoviesInPlatforms(movies2, platforms)
        assertEquals(true, result.isEmpty())
    }
}
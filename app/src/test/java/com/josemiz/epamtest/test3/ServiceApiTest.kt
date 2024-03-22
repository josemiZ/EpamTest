package com.josemiz.epamtest.test3

import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class ServiceApiTest {
    private val serviceApi = spyk<ServiceApi>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun sendUser() = runTest {
        val response = serviceApi.sendUser(UserLoginData("as", "roberto fernandez"))
        advanceUntilIdle()
        assertEquals(true, response)
    }
}
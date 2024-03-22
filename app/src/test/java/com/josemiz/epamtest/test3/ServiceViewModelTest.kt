package com.josemiz.epamtest.test3

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.josemiz.epamtest.MainCoroutineRule
import com.josemiz.epamtest.getOrAwaitValueTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@OptIn(ExperimentalCoroutinesApi::class)
class ServiceViewModelTest {


    private val serviceViewModel = ServiceViewModel(UserProcessor(), ServiceApi())

    @get:Rule
    val coroutineRule = MainCoroutineRule()
    @get:Rule var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun processAndLogin() = runTest {
        serviceViewModel.processAndLogin("miguel zea", 123)
        advanceUntilIdle()
        assertEquals("true", serviceViewModel.isLoaded.getOrAwaitValueTest())
    }
}
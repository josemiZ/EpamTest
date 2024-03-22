package com.josemiz.epamtest.test3

import kotlinx.coroutines.delay

class ServiceApi {

    suspend fun sendUser(login: UserLoginData):Boolean{
        //Simulate an api call
        delay(1000)
        return true
    }
}
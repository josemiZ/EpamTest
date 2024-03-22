package com.josemiz.epamtest.test3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ServiceViewModel(
    private val userProcessor: UserProcessor,
    private val serviceApi: ServiceApi
) : ViewModel() {

    private var _isLoaded = MutableLiveData<String>()
    val isLoaded: LiveData<String>
        get() = _isLoaded

    fun processAndLogin(name: String, cardId: Int) {
        viewModelScope.launch {
            val login = userProcessor.processUser(name, cardId)
            val isSuccessful = serviceApi.sendUser(login)
            _isLoaded.value = isSuccessful.toString()
        }

        //use the userProcess to process the name and cardId from the user and obtain the completed object.

        //call the serviceApi sending the data

        //update the ui writing the livedata

    }

}
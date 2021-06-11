package com.example.characters_api_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.characters_api_mvvm.API.RepositoryCallback
import com.example.characters_api_mvvm.model.Characters
import com.example.characters_api_mvvm.model.Repository

class MainActivityViewModel : ViewModel() {

    val characters = MutableLiveData<Characters>()
    val status = MutableLiveData<Boolean>()

    fun getAllCharacters() {
        Repository.fetchAllCharactersFromAPI(object : RepositoryCallback<Characters> {
            override fun onError() {
                status.value = false
            }

            override fun onSuccess(data: Characters) {
                characters.value = data
                status.value = true
            }
        })
    }
}
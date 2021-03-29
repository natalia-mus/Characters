package com.example.characters_api_mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val model = Repository()

    val characters = MutableLiveData<Characters>()

    fun getAllCharacters() {
        model.fetchAllCharactersFromAPI(object : RepositoryCallback<Characters> {
            override fun onError(error: String?) {
                Log.e("ViewModel", "error")
            }

            override fun onSuccess(data: Characters?) {
                characters.value = data
            }
        })
    }
}
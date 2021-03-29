package com.example.characters_api_mvvm

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    companion object {
        const val BASE_URL = "https://www.breakingbadapi.com/api/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: APIService = retrofit.create(APIService::class.java)

    val characters = MutableLiveData<Characters>()

    fun fetchAllCharactersFromAPI(callback: RepositoryCallback<Characters>) {
        apiService.getAllCharacters().enqueue(object : Callback<Characters> {
            override fun onFailure(call: Call<Characters>, t: Throwable) {
                callback.onError("error")
            }

            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body())
                    characters.value = response.body()
                }
            }
        })
    }
}
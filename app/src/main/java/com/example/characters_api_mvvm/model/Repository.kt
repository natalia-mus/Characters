package com.example.characters_api_mvvm.model

import com.example.characters_api_mvvm.API.APIService
import com.example.characters_api_mvvm.API.RepositoryCallback
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

    fun fetchAllCharactersFromAPI(callback: RepositoryCallback<Characters>) {
        apiService.getAllCharacters().enqueue(object : Callback<Characters> {
            override fun onFailure(call: Call<Characters>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.isSuccessful) {
                    if (response.body().isNullOrEmpty()) {
                        callback.onError()
                    } else {
                        response.body()?.let { callback.onSuccess(it) }
                    }
                }
            }
        })
    }
}
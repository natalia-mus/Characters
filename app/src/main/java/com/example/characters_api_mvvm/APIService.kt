package com.example.characters_api_mvvm

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("characters")
    fun getAllCharacters(): Call<Characters>
}
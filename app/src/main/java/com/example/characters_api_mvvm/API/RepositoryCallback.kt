package com.example.characters_api_mvvm.API

interface RepositoryCallback<T> {

    fun onError()
    fun onSuccess(data: T)
}
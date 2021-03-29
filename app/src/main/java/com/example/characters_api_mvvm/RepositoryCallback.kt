package com.example.characters_api_mvvm

interface RepositoryCallback<T> {

    fun onError(error: String?)
    fun onSuccess(data: T?)
}
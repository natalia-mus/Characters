package com.example.characters_api_mvvm.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterItem(
    val birthday: String,
    @SerializedName("char_id")
    val id: Int,
    @SerializedName("img")
    val image: String,
    val name: String,
    val nickname: String,
    val status: String
) : Parcelable
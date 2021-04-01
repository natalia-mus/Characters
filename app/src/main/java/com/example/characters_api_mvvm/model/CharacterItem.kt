package com.example.characters_api_mvvm.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterItem(
    /*@SerializedName("appearance")
    val appearance: List<Any>,*/
    @SerializedName("better_call_saul_appearance")
    val betterCallSaulAppearance: List<Int>,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("char_id")
    val id: Int,
    @SerializedName("img")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("portrayed")
    val portrayed: String,
    @SerializedName("status")
    val status: String
) : Parcelable
package com.example.countriesapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("png")
    val flag: String?,
)

data class Name(
    @SerializedName("common")
    val countryName: String?,
)


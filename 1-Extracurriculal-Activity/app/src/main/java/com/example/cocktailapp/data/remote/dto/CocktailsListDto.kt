package com.example.cocktailapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CocktailsListDto(
    val drinks: List<DrinkDto>?,
) {
    data class DrinkDto(
        @SerializedName("idDrink")
        val id: String,
        @SerializedName("strDrink")
        val name: String?,
        @SerializedName("strCategory")
        val category: String?,
        @SerializedName("strInstructions")
        val instructions: String?,
        @SerializedName("strDrinkThumb")
        val imageUrl: String,
    )
}

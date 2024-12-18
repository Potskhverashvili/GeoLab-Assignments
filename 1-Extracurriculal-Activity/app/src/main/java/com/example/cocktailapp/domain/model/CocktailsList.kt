package com.example.cocktailapp.domain.model

data class CocktailsList(
    val drinks: List<Drink>?,
) {
    data class Drink(
        val id: String,
        val name: String?,
        val category: String?,
        val instructions: String?,
        val imageUrl: String,
    )
}


package com.example.cocktailapp.data

import com.example.cocktailapp.data.remote.dto.CocktailsListDto
import com.example.cocktailapp.domain.model.CocktailsList

// Cocktails Dto to Cocktails
fun CocktailsListDto.toCocktailList() = CocktailsList(
    drinks = drinks?.map { drinkDto ->
        drinkDto.toDrink()
    }
)

fun CocktailsListDto.DrinkDto.toDrink() = CocktailsList.Drink(
    id, name, category, instructions, imageUrl
)

//
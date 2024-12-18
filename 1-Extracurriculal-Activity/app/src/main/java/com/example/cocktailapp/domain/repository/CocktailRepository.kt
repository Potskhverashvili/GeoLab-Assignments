package com.example.cocktailapp.domain.repository

import com.example.cocktailapp.core.OperationStatus
import com.example.cocktailapp.domain.model.CocktailsList
import retrofit2.Response

interface CocktailRepository {
    suspend fun getCocktails(cocktailName : String) : OperationStatus<CocktailsList>
}
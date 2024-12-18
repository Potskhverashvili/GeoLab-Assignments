package com.example.cocktailapp.data.repository

import com.example.cocktailapp.core.NetworkCallHelper
import com.example.cocktailapp.core.OperationStatus
import com.example.cocktailapp.core.map
import com.example.cocktailapp.data.remote.service.CocktailsService
import com.example.cocktailapp.data.toCocktailList
import com.example.cocktailapp.domain.model.CocktailsList
import com.example.cocktailapp.domain.repository.CocktailRepository

class CocktailRepositoryImpl(
    private val cocktailsService: CocktailsService,
) : CocktailRepository {
    override suspend fun getCocktails(cocktailName: String): OperationStatus<CocktailsList> {
        return NetworkCallHelper.safeApiCall {
            cocktailsService.getCocktails(cocktailName)
        }.map {
            it.toCocktailList()
        }
    }
}
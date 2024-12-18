package com.example.cocktailapp.data.remote.service

import com.example.cocktailapp.data.remote.dto.CocktailsListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsService {
    @GET("search.php")
    suspend fun getCocktails(@Query("s") cocktailName: String): Response<CocktailsListDto>
}
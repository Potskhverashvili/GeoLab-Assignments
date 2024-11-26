package com.example.harrypotter.data.repository

import com.example.harrypotter.api.RetrofitInstance
import com.example.harrypotter.data.model.MovieDetails
import com.example.harrypotter.data.model.MovieModel

class MovieRepository {
    private val api = RetrofitInstance.getApi()

    // movie list
    suspend fun getMovieList(): MovieModel? {
        return try {
            val movieResponse = api.getMoviesList()
            movieResponse.body()
        } catch (error: Exception) {
            null
        }
    }

    // movie details
    suspend fun getMovieDetails(id: String): MovieDetails? {
        return try {
            val movieDetailsResponse = api.getMovieDetails(id)
            movieDetailsResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}
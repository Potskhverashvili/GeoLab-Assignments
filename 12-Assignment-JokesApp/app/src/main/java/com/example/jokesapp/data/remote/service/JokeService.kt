package com.example.jokesapp.data.remote.service

import com.example.jokesapp.data.remote.dto.JokeDto
import retrofit2.Response
import retrofit2.http.GET

interface JokeService {
    @GET("random_joke")
    suspend fun getRandomJoke(): Response<JokeDto>
}
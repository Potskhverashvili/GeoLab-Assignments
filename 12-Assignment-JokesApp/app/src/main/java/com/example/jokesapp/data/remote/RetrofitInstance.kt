package com.example.jokesapp.data.remote

import com.example.jokesapp.data.remote.service.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://official-joke-api.appspot.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jokeService: JokeService = retrofit.create(JokeService::class.java)
}

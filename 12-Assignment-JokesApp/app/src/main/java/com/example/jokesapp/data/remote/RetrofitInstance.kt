package com.example.jokesapp.data.remote

import com.example.jokesapp.data.remote.service.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://official-joke-api.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jokeService = retrofit.create(JokeService::class.java)
}
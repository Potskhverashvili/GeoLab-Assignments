package com.example.harrypotter.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.potterdb.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApi(): Api {
        return getRetrofit().create(Api::class.java)
    }
}
package com.example.network.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.amiiboapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getMarioApi(): MarioApi {
        return getRetrofit().create(MarioApi::class.java)
    }
}
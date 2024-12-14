package com.example.countriesapp.di

import com.example.countriesapp.data.remote.service.CountryService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var networkModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Create Service
    single {
        get<Retrofit>().create(CountryService::class.java)
    }
}
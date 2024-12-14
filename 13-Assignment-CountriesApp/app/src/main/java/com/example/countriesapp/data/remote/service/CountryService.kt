package com.example.countriesapp.data.remote.service

import com.example.countriesapp.data.remote.dto.CountryDetailsDto
import com.example.countriesapp.data.remote.dto.CountryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("region/europe")
    suspend fun getCountries(): Response<List<CountryDto>>

    @GET("name/{countryName}")
    suspend fun getCountryByName(@Path("countryName") name: String): Response<List<CountryDetailsDto>>
}
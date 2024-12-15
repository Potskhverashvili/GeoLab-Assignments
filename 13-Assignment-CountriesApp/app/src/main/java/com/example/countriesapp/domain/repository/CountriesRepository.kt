package com.example.countriesapp.domain.repository

import com.example.countriesapp.core.OperationStatus
import com.example.countriesapp.domain.model.Country
import com.example.countriesapp.domain.model.CountryDetails

interface CountriesRepository {
    suspend fun getCountriesList(): OperationStatus<List<Country>>
    suspend fun geCountryByName(name: String): OperationStatus<List<CountryDetails>>
}
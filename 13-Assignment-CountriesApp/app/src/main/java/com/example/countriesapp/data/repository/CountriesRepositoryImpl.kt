package com.example.countriesapp.data.repository

import com.example.countriesapp.core.NetworkCallHelper
import com.example.countriesapp.core.OperationStatus
import com.example.countriesapp.core.map
import com.example.countriesapp.data.remote.service.CountryService
import com.example.countriesapp.data.toCountry
import com.example.countriesapp.data.toCountryDetails
import com.example.countriesapp.domain.model.Country
import com.example.countriesapp.domain.model.CountryDetails
import com.example.countriesapp.domain.repository.CountriesRepository

class CountriesRepositoryImpl(
    private val countryService: CountryService,
) : CountriesRepository {

    override suspend fun getCountriesList(): OperationStatus<List<Country>> {
        return NetworkCallHelper.safeApi {
            countryService.getCountries()
        }.map { countryDtoList ->
            countryDtoList.map { countryDto ->
                countryDto.toCountry()
            }
        }
    }

    override suspend fun geCountryByName(name: String): OperationStatus<List<CountryDetails>> {
        return NetworkCallHelper.safeApi {
            countryService.getCountryByName(name)
        }.map { countryDetailsDto ->
            countryDetailsDto.map { detailsDto ->
                detailsDto.toCountryDetails()
            }
        }
    }
}


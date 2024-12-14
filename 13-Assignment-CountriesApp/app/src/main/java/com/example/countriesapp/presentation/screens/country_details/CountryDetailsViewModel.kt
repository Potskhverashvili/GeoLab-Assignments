package com.example.countriesapp.presentation.screens.country_details

import androidx.lifecycle.ViewModel
import com.example.countriesapp.core.onFailure
import com.example.countriesapp.core.onSuccess
import com.example.countriesapp.domain.model.CountryDetails
import com.example.countriesapp.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class CountryDetailsViewModel(private val countryRepository: CountriesRepository) : ViewModel() {

    val countryDetailsFlow = MutableStateFlow<List<CountryDetails>?>(null)
    val showErrorFlow = MutableSharedFlow<Exception>()

     suspend fun getCountryDetails(name: String) {
        countryRepository.geCountryByName(name)
            .onSuccess {
                countryDetailsFlow.emit(it)
            }
            .onFailure {
                showErrorFlow.emit(it)
            }
    }
}
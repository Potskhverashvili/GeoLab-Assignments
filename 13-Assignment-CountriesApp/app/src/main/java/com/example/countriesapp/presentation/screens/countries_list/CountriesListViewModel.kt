package com.example.countriesapp.presentation.screens.countries_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.core.onFailure
import com.example.countriesapp.core.onSuccess
import com.example.countriesapp.domain.model.Country
import com.example.countriesapp.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CountriesListViewModel(
    private val countriesRepository: CountriesRepository,
) : ViewModel() {

    val countriesFlow = MutableStateFlow<List<Country>>(emptyList())
    val showErrorFlow = MutableSharedFlow<Exception>()

    init {
        getCountries()
    }

    // ----- Get Countries List ------
    private fun getCountries() = viewModelScope.launch {
        countriesRepository.getCountriesList()
            .onSuccess {
                countriesFlow.emit(it)
            }.onFailure {
                showErrorFlow.emit(it)
            }
    }
}
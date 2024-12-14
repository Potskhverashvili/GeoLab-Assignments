package com.example.countriesapp.di

import com.example.countriesapp.presentation.screens.countries_list.CountriesListViewModel
import com.example.countriesapp.presentation.screens.country_details.CountryDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelsModule = module {
    viewModelOf(::CountriesListViewModel)
    viewModelOf(::CountryDetailsViewModel)
}


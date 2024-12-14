package com.example.countriesapp.di

import com.example.countriesapp.presentation.screens.countries_list.CountriesListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::CountriesListViewModel)
}


package com.example.countriesapp.di

import com.example.countriesapp.data.repository.CountriesRepositoryImpl
import com.example.countriesapp.domain.repository.CountriesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::CountriesRepositoryImpl) bind CountriesRepository::class
}
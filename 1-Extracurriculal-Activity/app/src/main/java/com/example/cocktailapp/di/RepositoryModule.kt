package com.example.cocktailapp.di

import com.example.cocktailapp.data.repository.CocktailRepositoryImpl
import com.example.cocktailapp.domain.repository.CocktailRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::CocktailRepositoryImpl) bind CocktailRepository::class
}
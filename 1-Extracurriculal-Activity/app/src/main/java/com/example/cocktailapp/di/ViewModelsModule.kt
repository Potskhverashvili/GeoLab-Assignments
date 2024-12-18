package com.example.cocktailapp.di

import com.example.cocktailapp.presentation.screens.cocktails_list.CocktailsListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::CocktailsListViewModel)
}
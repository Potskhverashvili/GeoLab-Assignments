package com.example.cocktailapp.presentation.screens.cocktails_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.core.onFailure
import com.example.cocktailapp.core.onSuccess
import com.example.cocktailapp.domain.model.CocktailsList
import com.example.cocktailapp.domain.repository.CocktailRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CocktailsListViewModel(
    private val cocktailsRepository: CocktailRepository,
) : ViewModel() {
    val cocktailsFlow = MutableStateFlow(emptyList<CocktailsList.Drink>())
    val errorFlow = MutableSharedFlow<Throwable>()

    fun getCocktails(cocktailName: String = "margarita") = viewModelScope.launch {
        cocktailsRepository.getCocktails(cocktailName)
            .onSuccess {
                cocktailsFlow.emit(it.drinks ?: emptyList())
            }
            .onFailure {
                errorFlow.emit(it)
            }
    }
}
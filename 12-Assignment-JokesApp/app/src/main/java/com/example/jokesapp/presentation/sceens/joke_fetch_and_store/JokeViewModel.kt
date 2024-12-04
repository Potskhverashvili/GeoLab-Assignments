package com.example.jokesapp.presentation.sceens.joke_fetch_and_store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.core.onFailure
import com.example.jokesapp.core.onSuccess
import com.example.jokesapp.data.repository.JokeRepositoryImpl
import com.example.jokesapp.domain.model.Joke
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    // --- Repository ---
    private val jokeRepository = JokeRepositoryImpl()

    // --- Flows ---
    val jokeFlow = MutableStateFlow<Joke?>(null)
    val showErrorFlow = MutableSharedFlow<Exception>()

    // --- Get Joke From Api ----
    fun getJoke() = viewModelScope.launch {
        jokeRepository.getRandomJoke()
            .onSuccess { joke ->
                jokeFlow.emit(joke)
            }
            .onFailure { exception ->
                showErrorFlow.emit(exception)
            }
    }

    // --------- Save Joke ----------
    fun saveJoke() = viewModelScope.launch {
        val value = jokeFlow.value
        if (value != null) {
            jokeRepository.saveJoke(value)
        }
    }
}
package com.example.jokesapp.presentation.sceens.jokes_list

import androidx.lifecycle.ViewModel
import com.example.jokesapp.data.repository.JokeRepositoryImpl
import com.example.jokesapp.domain.model.Joke

class JokeLIstViewModel : ViewModel() {

    // --- Repository ---
    private val jokeRepository = JokeRepositoryImpl()

    // --- jokes Flow ---
    val jokesListFlow = jokeRepository.getJokeFromRoom()

    // --- delete joke ----
    suspend fun deleteJoke(joke: Joke) {
        jokeRepository.deleteJoke(joke)
    }
}
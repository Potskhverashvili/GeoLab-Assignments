package com.example.jokesapp.presentation.sceens.jokes_list

import androidx.lifecycle.ViewModel
import com.example.jokesapp.data.repository.JokeRepositoryImpl

class JokeLIstViewModel : ViewModel() {
    // Repository
    private val jokeRepository = JokeRepositoryImpl()

    // jokes Flow
    val jokesListFlow = jokeRepository.getJokeFromRoom()
}
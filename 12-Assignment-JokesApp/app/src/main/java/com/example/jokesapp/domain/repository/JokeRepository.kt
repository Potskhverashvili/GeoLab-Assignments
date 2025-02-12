package com.example.jokesapp.domain.repository

import com.example.jokesapp.core.OperationStatus
import com.example.jokesapp.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {
    suspend fun getRandomJoke(): OperationStatus<Joke>
    suspend fun saveJoke(joke: Joke)
    suspend fun deleteJoke(joke: Joke)
    fun getJokeFromRoom(): Flow<List<Joke>>
}
package com.example.jokesapp.data.repository

import com.example.JokeApplication
import com.example.jokesapp.core.NetworkCallHelper
import com.example.jokesapp.core.OperationStatus
import com.example.jokesapp.core.map
import com.example.jokesapp.data.local.data_base.JokesDatabase
import com.example.jokesapp.data.remote.RetrofitInstance
import com.example.jokesapp.data.toJoke
import com.example.jokesapp.data.toJokeEntity
import com.example.jokesapp.domain.model.Joke
import com.example.jokesapp.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class JokeRepositoryImpl : JokeRepository {
    private val jokeService = RetrofitInstance.jokeService
    private val jokeDao = JokesDatabase.create(JokeApplication.context).jokeDao

    // ---------------- Get Joke from Api -------------------
    override suspend fun getRandomJoke(): OperationStatus<Joke> {
        return NetworkCallHelper.safeApiCall {
            jokeService.getRandomJoke()
        }.map { jokeDto ->
            jokeDto.toJoke()
        }
    }

    //---------- Store and Get joke from Room Database --------
    override suspend fun saveJoke(joke: Joke) {
        return jokeDao.saveJoke(joke.toJokeEntity())
    }

    // ------------- Get Jokes From Room Database-----------------
    override  fun getJokeFromRoom(): Flow<List<Joke>> {
        return jokeDao.getJokes().map { jokeEntityList ->
            jokeEntityList.map { jokeEntity ->
                jokeEntity.toJoke()
            }
        }
    }


}
package com.example.jokesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.jokesapp.data.local.entity.JokeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {
    @Insert
    suspend fun saveJoke(jokeEntity: JokeEntity)

    @Delete
    suspend fun deleteJoke(jokeEntity: JokeEntity)

    @Query("SELECT * FROM jokes")
    fun getJokes(): Flow<List<JokeEntity>>
}
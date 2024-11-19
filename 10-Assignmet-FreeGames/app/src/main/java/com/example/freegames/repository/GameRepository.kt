package com.example.freegames.repository

import com.example.freegames.api.RetrofitInstance
import com.example.freegames.data.GameModel

class GameRepository {

    private val api = RetrofitInstance.getGameApi()

    suspend fun getCharactersList(): List<GameModel>? {
        return try {
            val gameResponse = api.getGameList()
            gameResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}
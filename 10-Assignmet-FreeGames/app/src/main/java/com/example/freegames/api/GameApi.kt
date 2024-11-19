package com.example.freegames.api

import com.example.freegames.data.GameModel
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {
    @GET("games")
    suspend fun getGameList(): Response<List<GameModel>>
}
package com.example.freegames.data

import com.google.gson.annotations.SerializedName

data class GameModel(
    val id: Int?,
    val title: String?,
    @SerializedName("thumbnail")
    val gameImage: String?,
    @SerializedName("game_url")
    val gameUrl: String?,
)

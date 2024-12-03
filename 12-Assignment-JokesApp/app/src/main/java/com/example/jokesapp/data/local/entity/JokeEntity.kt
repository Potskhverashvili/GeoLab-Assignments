package com.example.jokesapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeEntity(
    val type: String,
    val setup: String,
    val punchline: String,
    @PrimaryKey
    val id: Int,
)

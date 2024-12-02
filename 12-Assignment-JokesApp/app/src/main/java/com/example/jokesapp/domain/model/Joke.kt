package com.example.jokesapp.domain.model

data class Joke(
    val type: String,
    val setup: String,
    val punchline: String,
    val id: Int,
)

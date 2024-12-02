package com.example.jokesapp.data

import com.example.jokesapp.data.remote.dto.JokeDto
import com.example.jokesapp.domain.model.Joke

// Extension function of JokeDto
fun JokeDto.toJoke() = Joke(
    type = type,
    setup = setup,
    punchline = punchline,
    id = id
)
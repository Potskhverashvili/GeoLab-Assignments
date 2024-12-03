package com.example.jokesapp.data

import com.example.jokesapp.data.local.entity.JokeEntity
import com.example.jokesapp.data.remote.dto.JokeDto
import com.example.jokesapp.domain.model.Joke

// JokeDto to Joke
fun JokeDto.toJoke() = Joke(
    type = type,
    setup = setup,
    punchline = punchline,
    id = id
)


// Joke to jokeEntity
fun Joke.toJokeEntity() = JokeEntity(
    type = type,
    setup = setup,
    punchline = punchline,
    id = id
)

// JokeEntity to Joke
fun JokeEntity.toJoke() = Joke(
    type = type,
    setup = setup,
    punchline = punchline,
    id = id
)
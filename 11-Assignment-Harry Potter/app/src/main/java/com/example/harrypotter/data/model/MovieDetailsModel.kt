package com.example.harrypotter.data.model


data class MovieDetails(
    val data: MovieData,
)

data class MovieData(
    val id: String,
    val type: String,
    val attributes: MovieAttributes,
)

data class MovieAttributes(
    val poster: String,
    val summary: String,
)

package com.example.harrypotter.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    val data: List<MoviesDetails>,
)

data class MoviesDetails(
    val id: String,
    val attributes: MoviesAttributes,
)

data class MoviesAttributes(
    @SerializedName("poster")
    val moviePoster: String,
    val summary: String,
    @SerializedName("title")
    val movieName: String,
    val trailer: String,
)
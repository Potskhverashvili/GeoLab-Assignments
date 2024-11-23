package com.example.harrypotter.data.model

data class BookDetails(
    val data : Data
)
data class Data(
    val id: String,
    val type: String,
    val attributes: BookAttributes,
)

data class BookAttributes(
    val slug: String,
    val cover: String,
    val summary: String,
)


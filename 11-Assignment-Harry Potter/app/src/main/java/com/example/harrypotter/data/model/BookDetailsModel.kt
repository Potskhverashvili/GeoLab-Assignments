package com.example.harrypotter.data.model

data class BookDetails(
    val data: BookData,
)

data class BookData(
    val id: String,
    val type: String,
    val attributes: BookAttributes,
)

data class BookAttributes(
    val slug: String,
    val cover: String,
    val summary: String,
)


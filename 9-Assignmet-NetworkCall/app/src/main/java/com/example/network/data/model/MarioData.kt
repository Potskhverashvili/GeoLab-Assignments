package com.example.network.data.model

data class MarioData(
    val amiibo: List<Amiibo>,
) {
    data class Amiibo(
        val amiiboSeries: String,
        val character: String,
        val gameSeries: String,
        val head: String,
        val image: String,
        val name: String,
        val release: Release,
        val tail: String,
        val type: String,
    )
}


data class Release(
    val au: String,
    val eu: String,
    val jp: String,
    val na: String,
)

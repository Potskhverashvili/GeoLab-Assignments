package com.example.harrypotter.data.model

import com.google.gson.annotations.SerializedName

data class BookModel(
    val data: List<Detail>,
) {
    data class Detail(
        val id: String,
        val attributes: Attributes,
    )
}

data class Attributes(
    @SerializedName("slug")
    val bookName: String,
    val author: String,
    @SerializedName("cover")
    val coverImage: String,
)


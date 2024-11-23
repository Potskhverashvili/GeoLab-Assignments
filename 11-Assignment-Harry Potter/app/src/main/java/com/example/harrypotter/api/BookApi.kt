package com.example.harrypotter.api

import com.example.harrypotter.data.model.BookModel
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {

    @GET("books")
    suspend fun getBookList(): Response<BookModel>
}
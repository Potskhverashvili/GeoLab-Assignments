package com.example.harrypotter.api


import com.example.harrypotter.data.model.BookDetails
import com.example.harrypotter.data.model.BookModel
import com.example.harrypotter.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface BookApi {

    @GET("books")
    suspend fun getBookList(): Response<BookModel>

    @GET("books/{id}")
    suspend fun getBookDetails(@Path("id") id : String) : Response<BookDetails>


    @GET("movies")
    suspend fun getMoviesList() : Response<MovieModel>

}
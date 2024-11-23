package com.example.harrypotter.data.repository

import com.example.harrypotter.api.RetrofitInstance
import com.example.harrypotter.data.model.BookModel

class BookRepository {

    private val api = RetrofitInstance.getBookApi()

    suspend fun getBooksList(): BookModel? {
        return try {
            val bookResponse = api.getBookList()
            bookResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}
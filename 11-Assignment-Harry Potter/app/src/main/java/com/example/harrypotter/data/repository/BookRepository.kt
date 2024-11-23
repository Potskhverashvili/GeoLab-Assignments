package com.example.harrypotter.data.repository

import android.util.Log.d
import com.example.harrypotter.api.RetrofitInstance
import com.example.harrypotter.data.model.BookDetails
import com.example.harrypotter.data.model.Data
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

    suspend fun getBookDetails(id : String): BookDetails? {
        return try {
            val bookDetailsResponse = api.getBookDetails(id)
            bookDetailsResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}
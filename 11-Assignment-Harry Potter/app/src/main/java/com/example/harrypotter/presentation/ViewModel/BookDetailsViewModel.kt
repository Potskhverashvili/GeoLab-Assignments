package com.example.harrypotter.presentation.ViewModel

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.model.BookDetails
import com.example.harrypotter.data.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BookDetailsViewModel : ViewModel() {

    // Repo injection
    private val bookRepository = BookRepository()

    // Create A MutableStateFlow
    val bookDetailsFlow = MutableStateFlow<BookDetails?>(null)

    // get details
    fun getBookDetails(id: String) = viewModelScope.launch {
        val bookDetailsFromApi = bookRepository.getBookDetails(id)
        bookDetailsFlow.emit(bookDetailsFromApi)
    }
}

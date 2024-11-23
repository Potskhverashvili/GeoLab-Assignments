package com.example.harrypotter.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.model.BooksDetails
import com.example.harrypotter.data.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    // Repo injection
    private val bookRepository = BookRepository()

    // Create A MutableStateFlow
    val booksFlow = MutableStateFlow<List<BooksDetails>>(emptyList())

    init {
        getBooks()
    }

    private fun getBooks() = viewModelScope.launch {
        val booksFromApi = bookRepository.getBooksList()?.data ?: emptyList()
        booksFlow.emit(booksFromApi)
    }
}
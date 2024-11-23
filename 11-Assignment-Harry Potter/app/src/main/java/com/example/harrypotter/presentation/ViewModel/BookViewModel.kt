package com.example.harrypotter.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.model.BookModel
import com.example.harrypotter.data.repository.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    // Repo injection
    private val bookRepository = BookRepository()

    // Create A MutableStateFlow
    val booksFlow = MutableStateFlow<List<BookModel.Detail>>(emptyList())

    init {
        getBooks()
    }


    // Function to fetch games from the repository and emit them to the flow
    private fun getBooks() = viewModelScope.launch {
        val booksFromApi = bookRepository.getBooksList()
        booksFlow.emit(booksFromApi)
    }

}
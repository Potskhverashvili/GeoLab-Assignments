package com.example.harrypotter.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.model.MoviesDetails
import com.example.harrypotter.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    // Repo injection
    private val movieRepository = MovieRepository()

    // Create A MutableStateFlow
    val movieFlow = MutableStateFlow<List<MoviesDetails>>(emptyList())

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        val moviesFromApi = movieRepository.getMovieList()?.data ?: emptyList()
        movieFlow.emit(moviesFromApi)
    }
}
package com.example.harrypotter.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.model.MovieDetails
import com.example.harrypotter.data.model.MoviesDetails
import com.example.harrypotter.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {

    // Repo inj
    private val movieRepository = MovieRepository()

    // flow
    val movieDetailsFlow = MutableStateFlow<MovieDetails?>(null)

    // get movie details
    fun getMovieDetails(id: String) = viewModelScope.launch {
        val movieDetailsFromApi = movieRepository.getMovieDetails(id)
        movieDetailsFlow.emit(movieDetailsFromApi)
    }
}
package com.example.freegames.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegames.data.GameModel
import com.example.freegames.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    // Initialize the GameRepository
    private val gameRepository = GameRepository()

    // Create a MutableStateFlow to store and emit the list of games
    val gamesFlow = MutableStateFlow<List<GameModel>>(emptyList())


    init { // When the ViewModel is initialized, fetch the games
        getGames()
    }

    // Function to fetch games from the repository and emit them to the flow
    private fun getGames() = viewModelScope.launch {
        val gamesFromApi = gameRepository.getCharactersList() ?: emptyList()
        gamesFlow.emit(gamesFromApi)
    }
}
package com.example.freegames.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.freegames.databinding.ActivityGameBinding
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGameBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<GameViewModel>()
    private val gameAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecycler()
        setCollectors()
        setListener()
    }

    // Initializes the RecyclerView and sets the adapter
    private fun initRecycler() {
        binding.gameRecyclerView.adapter = gameAdapter

    }

    // Collects game data from the ViewModel and updates the adapter
    private fun setCollectors() {
        lifecycleScope.launch {
            viewModel.gamesFlow.collect {
                gameAdapter.updateGameList(it)
            }
        }
    }

    // Sets a click listener on the adapter to open game URLs in the browser
    private fun setListener() {
        gameAdapter.onClickLink = { gameModel ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gameModel.gameUrl))
            startActivity(intent)
        }
    }
}

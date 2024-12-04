package com.example.jokesapp.presentation.sceens.joke_fetch_and_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.jokesapp.databinding.FragmentJokeFetchAndStoreBinding
import kotlinx.coroutines.launch

class JokesFetchAndStore : Fragment() {
    private lateinit var binding: FragmentJokeFetchAndStoreBinding
    private val viewModel by viewModels<JokeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentJokeFetchAndStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setCollectors()
    }

    //--------- Set Listeners ----------
    private fun setListeners() = with(binding) {

        getNewJokeButton.setOnClickListener { // get joke from api
            viewModel.getJoke()
        }

        saveJokeButton.setOnClickListener { // save joke to Room Database
            viewModel.saveJoke()
            viewModel.getJoke()
        }

        storageJokesButton.setOnClickListener { // go to the storage page
            findNavController()
                .navigate(
                    JokesFetchAndStoreDirections
                        .actionJokesFetchAndStoreToJokesListFragment()
                )
        }
    }

    // -------- Set Collectors ----------
    private fun setCollectors() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.jokeFlow.collect { joke ->
            binding.jokeTypeTextView.text = joke?.type ?: "Click Get New Joke"
            binding.jokeSetupTextView.text = joke?.setup
            binding.jokePunchlineTextView.text = joke?.punchline
        }
    }
}
package com.example.jokesapp.presentation.sceens.joke_fetch_and_store

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.jokesapp.databinding.FragmentJokeFetchAndStoreBinding
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class JokesFetchAndStore : Fragment() {

    private lateinit var binding: FragmentJokeFetchAndStoreBinding

    //View Model
    private val viewModel by viewModels<JokeViewModel>()

    // -- on Create View --
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentJokeFetchAndStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    // -- on View Create --
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setCollectors()
    }

    // Set Listeners
    private fun setListeners() = with(binding) {
        // get joke from api
        getNewJokeButton.setOnClickListener {
            viewModel.getJoke()
        }
        // save joke to Room Database
        saveJokeButton.setOnClickListener {
            viewModel.saveJoke()
        }

        // go to the storage page
        storageJokesButton.setOnClickListener {
            findNavController().navigate(JokesFetchAndStoreDirections.actionJokesFetchAndStoreToJokesListFragment())
        }
    }

    // Set Collectors
    private fun setCollectors() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.jokeFlow.collect { joke ->
            binding.jokeTypeTextView.text = joke?.type ?: "Click Get New Joke"
            binding.jokeSetupTextView.text = joke?.setup
            binding.jokePunchlineTextView.text = joke?.punchline
        }
    }
}
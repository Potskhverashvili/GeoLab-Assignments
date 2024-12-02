package com.example.jokesapp.presentation.sceens.joke_fetch_and_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jokesapp.databinding.FragmentJokeFetchAndStoreBinding

class JokesFetchAndStore : Fragment() {
    private lateinit var binding: FragmentJokeFetchAndStoreBinding

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
    }
}
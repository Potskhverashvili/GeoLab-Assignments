package com.example.jokesapp.presentation.sceens.jokes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.jokesapp.databinding.FragmentJokesListBinding
import kotlinx.coroutines.launch

class JokesListFragment : Fragment() {

    private lateinit var binding: FragmentJokesListBinding
    private val viewModel by viewModels<JokeLIstViewModel>()
    private val jokeAdapter = JokeAdapter()

    // -- On Created View --
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentJokesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    // -- On View Created --
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setCollectors()
        setListeners()
    }

    // ----------- Init Views --------
    private fun initViews() {
        binding.jokeListRecyclerView.adapter = jokeAdapter
    }

    // ----------- Set Collectors ---------
    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.jokesListFlow.collect {
                jokeAdapter.submitList(it)
            }
        }
    }

    // ----------- Set Listeners -------------
    private fun setListeners()  {
        jokeAdapter.onDeleteClick = { joke ->
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.deleteJoke(joke)
            }
        }
    }
}
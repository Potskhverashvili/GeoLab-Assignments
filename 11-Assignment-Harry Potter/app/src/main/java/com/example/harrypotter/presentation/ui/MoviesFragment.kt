package com.example.harrypotter.presentation.ui

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.harrypotter.R
import com.example.harrypotter.databinding.FragmentMoviesBinding
import com.example.harrypotter.presentation.ViewModel.MovieViewModel
import com.example.harrypotter.presentation.adapter.MovieAdapter
import kotlinx.coroutines.launch


class MoviesFragment : Fragment() {
    //Properties
    private lateinit var binding: FragmentMoviesBinding
    private val movieViewModel by viewModels<MovieViewModel>()
    private val movieAdapter = MovieAdapter()
    private val navMovieButton = R.id.navMoviesButton
    private val navBookButton = R.id.navBooksButton


    // -------------------------- Override Methods ----------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()
        setCollector()
        setListeners()
    }


    // --------------------------------- Helpers ------------------------------

    // set recycler view
    private fun setRecycler() {
        binding.moviesRecyclerView.adapter = movieAdapter
    }


    //set collector
    private fun setCollector() {
        lifecycleScope.launch {
            movieViewModel.movieFlow.collect {
                movieAdapter.updateMovieList(it)
            }
        }
    }

    // set Listeners
    private fun setListeners() {
        // set onClickDetail button
        movieAdapter.onClickDetail = { currentMovie ->
            findNavController().navigate(
                MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment(
                    id = currentMovie.id
                )
            )
        }
    }
}
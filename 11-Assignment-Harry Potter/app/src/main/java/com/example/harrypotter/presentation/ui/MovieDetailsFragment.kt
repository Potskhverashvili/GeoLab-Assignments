package com.example.harrypotter.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harrypotter.databinding.FragmentMovieDetailsBinding
import com.example.harrypotter.presentation.ViewModel.MovieDetailsViewModel
import kotlinx.coroutines.launch


class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val movieDetailsVieModel by viewModels<MovieDetailsViewModel>()
    private val args by navArgs<MovieDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovieDetailsById()
        setCollector()
    }


    private fun getMovieDetailsById() {
        movieDetailsVieModel.getMovieDetails(args.id)
    }

    private fun setCollector() {
        lifecycleScope.launch {
            movieDetailsVieModel.movieDetailsFlow.collect {
                binding.movieSummaryTextView.text = it?.data?.attributes?.summary

                Glide.with(binding.root)
                    .load(it?.data?.attributes?.poster)
                    .into(binding.movieDetailsImageView)
            }
        }

    }
}
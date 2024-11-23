package com.example.harrypotter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harrypotter.databinding.FragmentBookDetailsBinding
import com.example.harrypotter.presentation.ViewModel.BookDetailsViewModel
import kotlinx.coroutines.launch

class BookDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBookDetailsBinding
    private val bookDetailsViewModel by viewModels<BookDetailsViewModel>()
    private val args by navArgs<BookDetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBookDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBookId()
        setCollector()
    }


    // ------------------------------ Helper Methods ------------------------
    private fun getBookId() {
        bookDetailsViewModel.getBookDetails(args.id)
    }

    private fun setCollector() {
        lifecycleScope.launch {
            bookDetailsViewModel.bookDetailsFlow.collect { bookDetail ->
                binding.bookSummaryTextView.text = bookDetail?.data?.attributes?.summary
                Glide.with(binding.root)
                    .load(bookDetail?.data?.attributes?.cover)
                    .into(binding.bookDetailsImageView)

            }
        }
    }
}
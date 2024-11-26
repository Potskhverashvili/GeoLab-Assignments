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
import com.example.harrypotter.R
import com.example.harrypotter.databinding.FragmentBookListBinding
import com.example.harrypotter.presentation.ViewModel.BookViewModel
import com.example.harrypotter.presentation.adapter.BookAdapter
import kotlinx.coroutines.launch

class BookListFragment : Fragment() {

    // Properties
    private lateinit var binding: FragmentBookListBinding
    private val bookAdapter = BookAdapter()
    private val bookViewModel by viewModels<BookViewModel>()

    // ------------------------------ Override Methods ---------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        setCollector()
        setListeners()
    }

    // ---------------------------------- Helper Methods ----------------------------
    // --- Init Recycler Method ---
    private fun initRecycler() {
        binding.bookRecyclerView.adapter = bookAdapter
    }

    // set collector
    private fun setCollector() {
        lifecycleScope.launch {
            bookViewModel.booksFlow.collect {
                bookAdapter.updateBookList(it)
            }
        }
    }

    // set listeners
    private fun setListeners() {
        // onClickDetail button
        bookAdapter.onClickDetail = { currentBook ->
            findNavController().navigate(
                BookListFragmentDirections.bookListFragmentToBookDetailsFragment(
                    id = currentBook.id
                )
            )
        }
    }
}

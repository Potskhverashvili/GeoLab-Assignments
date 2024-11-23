package com.example.harrypotter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.harrypotter.databinding.FragmentBookListBinding
import com.example.harrypotter.presentation.ViewModel.BookViewModel
import com.example.harrypotter.presentation.adapter.BookAdapter
import kotlinx.coroutines.launch

class BookListFragment : Fragment() {

    private lateinit var binding: FragmentBookListBinding
    private val bookAdapter = BookAdapter()
    private val viewModel by viewModels<BookViewModel>()

    // --- Init Recycler Method ---
    private fun initRecycler() {
        binding.bookRecyclerView.adapter = bookAdapter
    }

    private fun setCollector() {
        lifecycleScope.launch {
            viewModel.booksFlow.collect {
                bookAdapter.updateGameList(it)
            }
        }
    }


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
    }
}

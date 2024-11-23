package com.example.harrypotter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.harrypotter.databinding.FragmentBookListBinding
import com.example.harrypotter.presentation.adapter.BookAdapter

class BookListFragment : Fragment() {

    private val bookAdapter = BookAdapter()
    private lateinit var binding: FragmentBookListBinding


    // --- Init Recycler Method ---
    private fun initRecycler() {
        binding.bookRecyclerView.adapter = bookAdapter
    }

    private fun setCollector() {
        lifecycleScope.coroutineContext
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


    }


}
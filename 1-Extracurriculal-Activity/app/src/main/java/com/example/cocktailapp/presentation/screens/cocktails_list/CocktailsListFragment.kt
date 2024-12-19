package com.example.cocktailapp.presentation.screens.cocktails_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cocktailapp.databinding.FragmentCocktailsListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CocktailsListFragment : Fragment() {
    private lateinit var binding: FragmentCocktailsListBinding
    private val viewModel by viewModel<CocktailsListViewModel>()
    private val adapter = CocktailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCocktailsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setCollectors()
    }

    private fun initViews() {
        binding.cocktailRecyclerView.adapter = adapter
    }

    private fun setCollectors() {
        lifecycleScope.launch {
            viewModel.cocktailsFlow.collect {
                adapter.cocktailListUpdate(it)
            }
        }
    }
}



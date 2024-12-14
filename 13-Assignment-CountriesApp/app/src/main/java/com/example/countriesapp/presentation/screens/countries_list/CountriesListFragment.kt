package com.example.countriesapp.presentation.screens.countries_list

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.countriesapp.databinding.FragmentCountriesListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountriesListFragment : Fragment() {

    private lateinit var binding: FragmentCountriesListBinding
    private val viewModel by viewModel<CountriesListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCountriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCollector()

    }


    private fun setCollector() = lifecycleScope.launch {
        viewModel.countriesFlow.collect {
            d("MyLog", "collector: $it")
        }
    }
}




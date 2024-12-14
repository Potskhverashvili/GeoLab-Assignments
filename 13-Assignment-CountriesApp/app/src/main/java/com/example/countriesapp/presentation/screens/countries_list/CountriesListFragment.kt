package com.example.countriesapp.presentation.screens.countries_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.countriesapp.databinding.FragmentCountriesListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountriesListFragment : Fragment() {

    private lateinit var binding: FragmentCountriesListBinding
    private val viewModel by viewModel<CountriesListViewModel>()
    private val adapter = CountriesAdapter()

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
        initViews()
        setCollector()
        setListeners()
    }

    // ----- Init Views ------
    private fun initViews() {
        binding.countriesRecyclerView.adapter = adapter
    }

    // ----- Set Collectors ---
    private fun setCollector() = lifecycleScope.launch {
        viewModel.countriesFlow.collect {
            adapter.submitList(it)
        }
    }

    // ----- Set Listeners ----
    private fun setListeners() {
        adapter.onDetailClick = { currentCountry ->
            findNavController()
                .navigate(
                    CountriesListFragmentDirections.actionCountriesListFragmentToCountryDetailsFragment(
                        countryName = currentCountry.name?.countryName.toString()
                    )
                )
        }
    }
}




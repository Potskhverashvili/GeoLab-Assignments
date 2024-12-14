package com.example.countriesapp.presentation.screens.country_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.countriesapp.databinding.FragmentCountryDetailsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCountryDetailsBinding
    private val viewModel by viewModel<CountryDetailsViewModel>()
    private val args by navArgs<CountryDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCountryDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCountryDetails()
        setCollectors()
    }


    // ---- Get Country Details -----
    private fun getCountryDetails() = lifecycleScope.launch {
        viewModel.getCountryDetails(args.countryName)
    }

    // ------ Set Collectors -------
    private fun setCollectors() = with(binding) {
        lifecycleScope.launch {
            viewModel.countryDetailsFlow.collect {
                val countryDetails = it?.get(0)
                countryNameTextView.text = countryDetails?.name?.countryName
                capitalNameTextView.text = countryDetails?.capital?.get(0)
                Glide.with(root)
                    .load(countryDetails?.flags?.flag)
                    .into(flagImageView)
            }
        }
    }
}
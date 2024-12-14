package com.example.countriesapp.presentation.screens.countries_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countriesapp.databinding.ItemCountryBinding
import com.example.countriesapp.domain.model.Country

class CountriesAdapter :
    ListAdapter<Country, CountriesAdapter.CountriesViewHolder>(CountryItemCallBack()) {
    var onDetailClick: (Country) -> Unit = {} // Lambda Function For Details

    // ----------------------- View Holder ------------------------
    inner class CountriesViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) = with(binding) {
            countryNameTextView.text = country.name?.countryName.toString()
            detailsButton.setOnClickListener { onDetailClick(country) }
            Glide.with(root)
                .load(country.flag?.flag)
                .into(flagImageView)
        }
    }

    // --------------------- DiffUtil CallBack ---------------------
    class CountryItemCallBack : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem
    }

    // --------------------- Override Methods -----------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
package com.example.countriesapp.data

import com.example.countriesapp.data.remote.dto.CountryDetailsDto
import com.example.countriesapp.data.remote.dto.CountryDto
import com.example.countriesapp.domain.model.Country
import com.example.countriesapp.domain.model.CountryDetails

// ---- CountryDto to Country ----
fun CountryDto.toCountry() = Country(
    name = name,
    capital = capital,
    flags = flags
)

// ---- CountryDetailsDto to CountryDetails -----
fun CountryDetailsDto.toCountryDetails() = CountryDetails(
    name = name,
    capital = capital,
    flags = flags
)

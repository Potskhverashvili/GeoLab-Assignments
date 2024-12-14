package com.example.countriesapp.domain.model

import com.example.countriesapp.data.remote.dto.Flags
import com.example.countriesapp.data.remote.dto.Name

data class CountryDetails(
    val name: Name?,
    val capital: List<String>?,
    val flags: Flags?,
)
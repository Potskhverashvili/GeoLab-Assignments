package com.example.countriesapp.domain.model

import com.example.countriesapp.data.remote.dto.Flags
import com.example.countriesapp.data.remote.dto.Name

data class CountryDetails (
    private val name: Name?,
    private val capital: List<String>?,
    private val flags: Flags?,
)
package com.example.countriesapp.data.remote.dto

data class CountryDetailsDto(
    val name: Name?,
    val capital: List<String>?,
    val flags: Flags?,
)

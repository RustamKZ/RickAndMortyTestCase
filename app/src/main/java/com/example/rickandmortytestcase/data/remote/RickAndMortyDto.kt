package com.example.rickandmortytestcase.data.remote


data class RickAndMortyDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDto,
    val location: LocationDto,
    val image: String,
)

data class OriginDto(
    val name: String,
    val url: String,
)

data class LocationDto(
    val name: String,
    val url: String,
)
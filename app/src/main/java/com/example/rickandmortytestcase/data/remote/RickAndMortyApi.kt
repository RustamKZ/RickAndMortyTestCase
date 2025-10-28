package com.example.rickandmortytestcase.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersResponse

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}

data class CharactersResponse(
    val info: InfoDto,
    val results: List<RickAndMortyDto>
)

data class InfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)


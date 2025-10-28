package com.example.rickandmortytestcase.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface RickAndMortyDao {

    @Upsert
    suspend fun upsertAll(beers: List<CharacterEntity>)

    @Query("SELECT * FROM characters ")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("DELETE FROM characters")
    suspend fun clearAll()
}
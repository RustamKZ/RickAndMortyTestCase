package com.example.rickandmortytestcase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CharacterEntity::class],
    version = 1
)
abstract class RickAndMortyDb: RoomDatabase() {

    abstract val dao: RickAndMortyDao
}
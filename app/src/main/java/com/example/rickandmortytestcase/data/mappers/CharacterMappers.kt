package com.example.rickandmortytestcase.data.mappers

import com.example.rickandmortytestcase.data.local.CharacterEntity
import com.example.rickandmortytestcase.data.remote.RickAndMortyDto
import com.example.rickandmortytestcase.domain.CharacterInfo


fun RickAndMortyDto.toCharEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.name,
        location = location.name,
        image = image
    )
}

fun CharacterEntity.toCharacter(): CharacterInfo {
    return CharacterInfo(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        location = location,
        image = image
    )
}
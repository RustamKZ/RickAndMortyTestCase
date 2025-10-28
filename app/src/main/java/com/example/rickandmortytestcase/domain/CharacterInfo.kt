package com.example.rickandmortytestcase.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class CharacterInfo(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String
): Parcelable
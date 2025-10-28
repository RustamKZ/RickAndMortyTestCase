package com.example.rickandmortytestcase.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmortytestcase.domain.CharacterInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterViewModel : ViewModel() {
    private val _selectedCharacter = MutableStateFlow<CharacterInfo?>(null)
    val selectedCharacter: StateFlow<CharacterInfo?> = _selectedCharacter

    fun selectCharacter(character: CharacterInfo) {
        _selectedCharacter.value = character
    }
}
package com.example.rickandmortytestcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortytestcase.navigation.AppNavHost
import com.example.rickandmortytestcase.presentation.RickAndMortyViewModel
import com.example.rickandmortytestcase.ui.theme.CustomBlackBackground
import com.example.rickandmortytestcase.ui.theme.RickAndMortyTestCaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTestCaseTheme() {
                Scaffold(
                    containerColor = CustomBlackBackground
                ) { paddingValues ->
                    val viewModel = hiltViewModel<RickAndMortyViewModel>()
                    val characters = viewModel.charPagingFlow.collectAsLazyPagingItems()
                    AppNavHost(
                        modifier = Modifier.padding(paddingValues),
                        characters = characters
                    )
                }
            }
        }
    }
}
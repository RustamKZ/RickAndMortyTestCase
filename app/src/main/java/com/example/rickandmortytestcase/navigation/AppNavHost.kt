package com.example.rickandmortytestcase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import com.example.rickandmortytestcase.domain.CharacterInfo
import com.example.rickandmortytestcase.presentation.CharacterViewModel
import com.example.rickandmortytestcase.screens.DetailsScreen
import com.example.rickandmortytestcase.screens.MainScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    characters: LazyPagingItems<CharacterInfo>,
    viewModel: CharacterViewModel = viewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            MainScreen(
                modifier,
                navController,
                characters,
                viewModel
            )
        }
        composable("details") {
            val character = viewModel.selectedCharacter.collectAsState().value

            character?.let {
                DetailsScreen(
                    modifier,
                    navController,
                    it
                )
            }
        }
    }
}
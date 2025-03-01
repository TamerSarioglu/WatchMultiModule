package com.movieapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberMovieNavigationActions(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    MovieNavigationActions(navController)
} 
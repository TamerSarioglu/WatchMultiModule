package com.movieapp.feature.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieapp.core.navigation.MovieNavigation
import com.movieapp.feature.home.HomeScreen
import com.movieapp.feature.home.MainScreen

/**
 * Extension function that adds the Home feature's navigation graph to a NavGraphBuilder
 */
fun NavGraphBuilder.homeGraph(
    onMovieClick: (Int) -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToFavorites: () -> Unit
) {
    composable(route = MovieNavigation.Home.route) {
        MainScreen(
            onMovieClick = onMovieClick,
            onNavigateToSearch = onNavigateToSearch,
            onNavigateToFavorites = onNavigateToFavorites
        )
    }
} 
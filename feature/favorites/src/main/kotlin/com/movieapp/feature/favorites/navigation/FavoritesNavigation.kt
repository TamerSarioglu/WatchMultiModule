package com.movieapp.feature.favorites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieapp.core.navigation.MovieNavigation
import com.movieapp.feature.favorites.FavoritesScreen

/**
 * Extension function that adds the Favorites feature's navigation graph to a NavGraphBuilder
 */
fun NavGraphBuilder.favoritesGraph(
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit
) {
    composable(route = MovieNavigation.Favorites.route) {
        FavoritesScreen(
            onNavigateUp = onNavigateUp,
            onMovieClick = onMovieClick
        )
    }
}
package com.movieapp.feature.favorites.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieapp.core.navigation.MovieNavigation

/**
 * Extension function that adds the Favorites feature's navigation graph to a NavGraphBuilder
 */
fun NavGraphBuilder.favoritesGraph(
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit
) {
    composable(route = MovieNavigation.Favorites.route) {
        // Placeholder until the actual FavoritesScreen is implemented
        FavoritesScreenPlaceholder(
            onNavigateUp = onNavigateUp,
            onMovieClick = onMovieClick
        )
    }
}

@Composable
private fun FavoritesScreenPlaceholder(
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Favorites Screen - Coming Soon")
    }
} 
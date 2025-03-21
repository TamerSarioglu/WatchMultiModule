package com.movieapp.feature.search.navigation

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
 * Extension function that adds the Search feature's navigation graph to a NavGraphBuilder
 */
fun NavGraphBuilder.searchGraph(
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit
) {
    composable(route = MovieNavigation.Search.route) {
        // Placeholder until the actual SearchScreen is implemented
        SearchScreenPlaceholder(
            onNavigateUp = onNavigateUp,
            onMovieClick = onMovieClick
        )
    }
}

@Composable
private fun SearchScreenPlaceholder(
    onNavigateUp: () -> Unit,
    onMovieClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Search Screen - Coming Soon")
    }
} 
package com.movieapp.feature.search.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.movieapp.core.navigation.MovieNavigationActions
import com.movieapp.feature.search.SearchScreen

/**
 * Navigation route for the Search screen
 */
@Composable
fun SearchRoute(
    navController: NavHostController,
    navigationActions: MovieNavigationActions
) {
    SearchScreen(
        onMovieClick = { movieId ->
            navigationActions.navigateToMovieDetail(movieId)
        },
        onBackClick = {
            navigationActions.navigateUp()
        }
    )
} 
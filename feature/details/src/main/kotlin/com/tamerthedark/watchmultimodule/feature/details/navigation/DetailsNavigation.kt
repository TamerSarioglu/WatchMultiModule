package com.tamerthedark.watchmultimodule.feature.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.movieapp.core.navigation.MovieNavigation
import com.tamerthedark.watchmultimodule.feature.details.DetailsScreen

/**
 * Extension function that adds the Details feature's navigation graph to a NavGraphBuilder
 */
fun NavGraphBuilder.detailsGraph(
    onNavigateUp: () -> Unit
) {
    composable(
        route = MovieNavigation.MovieDetail.route,
        arguments = listOf(
            navArgument("movieId") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable
        DetailsScreen(
            movieId = movieId,
            onNavigateUp = onNavigateUp
        )
    }
} 
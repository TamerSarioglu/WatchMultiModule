package com.movieapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

class MovieNavigationFactory {
    
    @Composable
    fun CreateNavigation(
        navController: NavHostController,
        startDestination: String = MovieNavigation.Home.route,
        homeScreen: @Composable () -> Unit,
        popularScreen: @Composable () -> Unit,
        topRatedScreen: @Composable () -> Unit,
        movieDetailScreen: @Composable (Int) -> Unit
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            addHomeScreen(homeScreen)
            addPopularScreen(popularScreen)
            addTopRatedScreen(topRatedScreen)
            addMovieDetailScreen(movieDetailScreen)
        }
    }
    
    private fun NavGraphBuilder.addHomeScreen(
        homeScreen: @Composable () -> Unit
    ) {
        composable(route = MovieNavigation.Home.route) {
            homeScreen()
        }
    }
    
    private fun NavGraphBuilder.addPopularScreen(
        popularScreen: @Composable () -> Unit
    ) {
        composable(route = MovieNavigation.Popular.route) {
            popularScreen()
        }
    }
    
    private fun NavGraphBuilder.addTopRatedScreen(
        topRatedScreen: @Composable () -> Unit
    ) {
        composable(route = MovieNavigation.TopRated.route) {
            topRatedScreen()
        }
    }
    
    private fun NavGraphBuilder.addMovieDetailScreen(
        movieDetailScreen: @Composable (Int) -> Unit
    ) {
        composable(
            route = MovieNavigation.MovieDetail.route,
            arguments = listOf(
                navArgument("movieId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable
            movieDetailScreen(movieId)
        }
    }
} 
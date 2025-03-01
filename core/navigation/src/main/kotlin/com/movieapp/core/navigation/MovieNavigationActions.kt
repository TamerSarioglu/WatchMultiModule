package com.movieapp.core.navigation

import androidx.navigation.NavHostController

class MovieNavigationActions(private val navController: NavHostController) {
    
    fun navigateToHome() {
        navController.navigate(MovieNavigation.Home.route) {
            popUpTo(0)
        }
    }
    
    fun navigateToPopular() {
        navController.navigate(MovieNavigation.Popular.route)
    }
    
    fun navigateToTopRated() {
        navController.navigate(MovieNavigation.TopRated.route)
    }
    
    fun navigateToMovieDetail(movieId: Int) {
        navController.navigate(MovieNavigation.MovieDetail.createRoute(movieId))
    }
    
    fun navigateUp() {
        navController.navigateUp()
    }
} 
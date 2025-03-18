package com.movieapp.core.navigation.extensions

import androidx.navigation.NavController
import com.movieapp.core.navigation.MovieNavigation

/**
 * Navigation extensions for NavController to provide type-safe and clean navigation
 */

fun NavController.navigateToHome() {
    navigate(MovieNavigation.Home.route) {
        popUpTo(0)
    }
}

fun NavController.navigateToPopular() {
    navigate(MovieNavigation.Popular.route)
}

fun NavController.navigateToTopRated() {
    navigate(MovieNavigation.TopRated.route)
}

fun NavController.navigateToMovieDetail(movieId: Int) {
    navigate(MovieNavigation.MovieDetail.createRoute(movieId))
}

fun NavController.navigateToSearch() {
    navigate(MovieNavigation.Search.route)
}

fun NavController.navigateToFavorites() {
    navigate(MovieNavigation.Favorites.route)
} 
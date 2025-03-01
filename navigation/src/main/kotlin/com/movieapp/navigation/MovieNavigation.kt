package com.movieapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object MovieNavigation {
    const val ROUTE_HOME = "home"
    const val ROUTE_DETAILS = "details"
    const val ROUTE_SEARCH = "search"
    const val ROUTE_FAVORITES = "favorites"
    
    const val ARG_MOVIE_ID = "movieId"
}

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(MovieNavigation.ROUTE_HOME, navOptions)
}

fun NavController.navigateToDetails(movieId: Int, navOptions: NavOptions? = null) {
    this.navigate("${MovieNavigation.ROUTE_DETAILS}/$movieId", navOptions)
}

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    this.navigate(MovieNavigation.ROUTE_SEARCH, navOptions)
}

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    this.navigate(MovieNavigation.ROUTE_FAVORITES, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onMovieClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    composable(route = MovieNavigation.ROUTE_HOME) {
        // HomeScreen will be implemented in the feature module
    }
}

fun NavGraphBuilder.detailsScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = "${MovieNavigation.ROUTE_DETAILS}/{${MovieNavigation.ARG_MOVIE_ID}}",
        arguments = listOf(
            navArgument(MovieNavigation.ARG_MOVIE_ID) {
                type = NavType.IntType
            }
        )
    ) {
        // DetailsScreen will be implemented in the feature module
    }
}

fun NavGraphBuilder.searchScreen(
    onMovieClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    composable(route = MovieNavigation.ROUTE_SEARCH) {
        // SearchScreen will be implemented in the feature module
    }
}

fun NavGraphBuilder.favoritesScreen(
    onMovieClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    composable(route = MovieNavigation.ROUTE_FAVORITES) {
        // FavoritesScreen will be implemented in the feature module
    }
} 
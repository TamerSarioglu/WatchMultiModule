package com.movieapp.core.navigation

sealed class MovieNavigation(val route: String) {
    data object Home : MovieNavigation("home")
    data object Popular : MovieNavigation("popular")
    data object TopRated : MovieNavigation("top_rated")
    data object MovieDetail : MovieNavigation("movie/{movieId}") {
        fun createRoute(movieId: Int) = "movie/$movieId"
    }
    data object Search : MovieNavigation("search")
    data object Favorites : MovieNavigation("favorites")
} 
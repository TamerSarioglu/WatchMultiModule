package com.movieapp.core.navigation

sealed class MovieNavigation(val route: String) {
    object Home : MovieNavigation("home")
    object Popular : MovieNavigation("popular")
    object TopRated : MovieNavigation("top_rated")
    object MovieDetail : MovieNavigation("movie/{movieId}") {
        fun createRoute(movieId: Int) = "movie/$movieId"
    }
} 
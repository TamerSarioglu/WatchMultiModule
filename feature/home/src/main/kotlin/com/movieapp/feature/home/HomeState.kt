package com.movieapp.feature.home

import com.movieapp.core.network.models.Movie


data class HomeState(
    val popularMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val nowPlayingMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
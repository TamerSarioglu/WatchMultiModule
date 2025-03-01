package com.movieapp.feature.home

import com.movieapp.core.domain.model.MovieDomain

data class HomeState(
    val popularMovies: List<MovieDomain> = emptyList(),
    val topRatedMovies: List<MovieDomain> = emptyList(),
    val nowPlayingMovies: List<MovieDomain> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) 
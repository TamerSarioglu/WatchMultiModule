package com.movieapp.feature.favorites

import com.movieapp.core.domain.model.MovieDomain

data class FavoritesState(
    val favoriteMovies: List<MovieDomain> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
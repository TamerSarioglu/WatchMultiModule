package com.movieapp.feature.home

sealed interface HomeEvent {
    data object Retry : HomeEvent
    data object ClearError : HomeEvent
    data class MovieClicked(val movieId: Int) : HomeEvent
} 
package com.movieapp.feature.search

/**
 * Events for the Search screen
 */
sealed class SearchEvent {
    data class OnQueryChange(val query: String) : SearchEvent()
    data object OnSearch : SearchEvent()
    data object OnClearSearch : SearchEvent()
    data class OnMovieClick(val movieId: Int) : SearchEvent()
} 
package com.movieapp.feature.search

import com.movieapp.core.domain.model.MovieDomain

/**
 * State class for the Search screen
 */
data class SearchState(
    val query: String = "",
    val searchResults: List<MovieDomain> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSearching: Boolean = false,
    val isEmpty: Boolean = false
) 
package com.movieapp.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.domain.mapper.MovieMapper
import com.movieapp.core.domain.model.MovieDomain
import com.movieapp.core.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChange -> {
                _state.update { it.copy(query = event.query) }
                
                if (event.query.isEmpty()) {
                    // Clear results when query is empty
                    _state.update { 
                        it.copy(
                            searchResults = emptyList(),
                            isSearching = false,
                            isEmpty = false
                        ) 
                    }
                }
            }
            
            is SearchEvent.OnSearch -> {
                if (_state.value.query.isNotBlank()) {
                    searchMovies(_state.value.query)
                }
            }
            
            is SearchEvent.OnClearSearch -> {
                _state.update { 
                    it.copy(
                        query = "", 
                        searchResults = emptyList(),
                        isSearching = false,
                        isEmpty = false
                    ) 
                }
            }
            
            is SearchEvent.OnMovieClick -> {
                // Handled by the composable
            }
        }
    }

    private fun searchMovies(query: String) {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, isSearching = true, error = null) }
                
                val response = movieRepository.searchMovies(query, 1)
                val movies = response.results.map { movie ->
                    movieMapper.mapToDomain(movie)
                }
                
                _state.update { 
                    it.copy(
                        searchResults = movies,
                        isLoading = false,
                        isEmpty = movies.isEmpty()
                    ) 
                }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        error = e.message ?: "An unknown error occurred",
                        isLoading = false
                    ) 
                }
            }
        }
    }
} 
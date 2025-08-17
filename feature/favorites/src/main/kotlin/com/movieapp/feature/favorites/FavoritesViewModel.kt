package com.movieapp.feature.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    // TODO: Inject favorites repository when implemented
) : ViewModel() {

    private val _state = MutableStateFlow(FavoritesState())
    val state: StateFlow<FavoritesState> = _state.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                // TODO: Load favorites from repository
                // For now, simulate empty favorites
                _state.update {
                    it.copy(
                        favoriteMovies = emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load favorites: ${e.localizedMessage}"
                    )
                }
            }
        }
    }

    fun retryLoading() {
        loadFavorites()
    }

    fun removeFavorite(movieId: Int) {
        viewModelScope.launch {
            try {
                // TODO: Remove from repository
                // For now, remove from current state
                _state.update { currentState ->
                    currentState.copy(
                        favoriteMovies = currentState.favoriteMovies.filter { it.id != movieId }
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(error = "Failed to remove favorite: ${e.localizedMessage}")
                }
            }
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}
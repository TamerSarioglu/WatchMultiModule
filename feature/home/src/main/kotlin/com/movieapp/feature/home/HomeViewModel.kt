package com.movieapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.domain.usecase.GetPopularMoviesUseCase
import com.movieapp.core.domain.usecase.GetTopRatedMoviesUseCase
import com.movieapp.core.domain.usecase.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }
                
                // Launch parallel requests
                val popularDeferred = viewModelScope.launch {
                    try {
                        val response = getPopularMoviesUseCase(1)
                        _state.update { it.copy(popularMovies = response.results) }
                    } catch (e: Exception) {
                        _state.update { it.copy(error = "Failed to load popular movies") }
                    }
                }

                val topRatedDeferred = viewModelScope.launch {
                    try {
                        val response = getTopRatedMoviesUseCase(1)
                        _state.update { it.copy(topRatedMovies = response.results) }
                    } catch (e: Exception) {
                        _state.update { it.copy(error = "Failed to load top rated movies") }
                    }
                }

                val nowPlayingDeferred = viewModelScope.launch {
                    try {
                        val response = getNowPlayingMoviesUseCase(1)
                        _state.update { it.copy(nowPlayingMovies = response.results) }
                    } catch (e: Exception) {
                        _state.update { it.copy(error = "Failed to load now playing movies") }
                    }
                }

                // Wait for all requests to complete
                popularDeferred.join()
                topRatedDeferred.join()
                nowPlayingDeferred.join()
                
                _state.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false,
                        error = "Failed to load movies: ${e.localizedMessage}"
                    )
                }
            }
        }
    }

    fun retryLoading() {
        loadMovies()
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
} 
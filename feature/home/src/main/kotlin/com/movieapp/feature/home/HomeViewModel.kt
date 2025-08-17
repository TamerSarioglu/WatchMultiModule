package com.movieapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                // Use async for parallel execution but with proper error handling
                val popularDeferred = async {
                    runCatching { moviesUseCase.getPopularMovies(1) }
                }
                val topRatedDeferred = async {
                    runCatching { moviesUseCase.getTopRatedMovies(1) }
                }
                val nowPlayingDeferred = async {
                    runCatching { moviesUseCase.getNowPlayingMovies(1) }
                }

                // Await all results
                val popularResult = popularDeferred.await()
                val topRatedResult = topRatedDeferred.await()
                val nowPlayingResult = nowPlayingDeferred.await()

                // Update state based on results
                _state.update { currentState ->
                    currentState.copy(
                        popularMovies = popularResult.getOrNull() ?: emptyList(),
                        topRatedMovies = topRatedResult.getOrNull() ?: emptyList(),
                        nowPlayingMovies = nowPlayingResult.getOrNull() ?: emptyList(),
                        isLoading = false,
                        error = getFirstErrorMessage(
                            popularResult,
                            topRatedResult,
                            nowPlayingResult
                        )
                    )
                }
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

    private fun getFirstErrorMessage(
        popularResult: Result<*>,
        topRatedResult: Result<*>,
        nowPlayingResult: Result<*>
    ): String? {
        return listOf(popularResult, topRatedResult, nowPlayingResult)
            .firstOrNull { it.isFailure }
            ?.exceptionOrNull()
            ?.localizedMessage
    }

    fun retryLoading() {
        loadMovies()
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
} 
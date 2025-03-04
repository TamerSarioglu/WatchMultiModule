package com.tamerthedark.watchmultimodule.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.domain.model.MovieDetailDomain
import com.movieapp.core.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
    @Inject constructor(
        private val getMovieDetailsUseCase: GetMovieDetailsUseCase
    ):ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true, error = null) }
                val movieDetails = getMovieDetailsUseCase.execute(movieId)
                _state.update { it.copy(isLoading = false, movieDetail = movieDetails) }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false, 
                        error = "Failed to load movie details: ${e.localizedMessage}"
                    ) 
                }
            }
        }
    }
}
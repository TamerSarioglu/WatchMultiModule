package com.movieapp.feature.details

import androidx.lifecycle.ViewModel
import com.movieapp.core.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
    @Inject constructor(
        private val repository: MovieRepository
    ):ViewModel() {

    fun getMovieDetails(movieId: Int) {
        // Implement your logic here
    }

}
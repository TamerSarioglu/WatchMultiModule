package com.movieapp.core.domain.usecase

import com.movieapp.core.data.repository.MovieRepository
import com.movieapp.core.network.models.MovieResponse
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(page: Int): MovieResponse {
        return movieRepository.getNowPlayingMovies(page)
    }
} 
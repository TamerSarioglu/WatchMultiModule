package com.movieapp.core.domain.usecase

import com.movieapp.core.repository.MovieRepository
import com.movieapp.core.domain.mapper.MovieMapper
import com.movieapp.core.domain.model.MovieDetailDomain
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {
    suspend fun execute(movieId: Int): MovieDetailDomain {
        val movieDetail = movieRepository.getMovieDetails(movieId)
        return movieMapper.mapToDomain(movieDetail)
    }
} 
package com.movieapp.core.domain.usecase

import com.movieapp.core.domain.mapper.MovieMapper
import com.movieapp.core.domain.model.MovieDetailDomain
import com.movieapp.core.network.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {
    suspend operator fun invoke(movieId: Int): MovieDetailDomain {
        return movieMapper.mapToDomain(movieRepository.getMovieDetails(movieId))
    }
} 
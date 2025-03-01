package com.movieapp.core.domain.usecase

import com.movieapp.core.domain.mapper.MovieMapper
import com.movieapp.core.domain.model.MovieDomain
import com.movieapp.core.network.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {
    suspend fun getPopularMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getPopularMovies(page).map { movieMapper.mapToDomain(it) }
    }

    suspend fun getTopRatedMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getTopRatedMovies(page).map { movieMapper.mapToDomain(it) }
    }

    suspend fun getNowPlayingMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getNowPlayingMovies(page).map { movieMapper.mapToDomain(it) }
    }

    suspend fun searchMovies(query: String, page: Int = 1): List<MovieDomain> {
        return movieRepository.searchMovies(query, page).map { movieMapper.mapToDomain(it) }
    }
} 
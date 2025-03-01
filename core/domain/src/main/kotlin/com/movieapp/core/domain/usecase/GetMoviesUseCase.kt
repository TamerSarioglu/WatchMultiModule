package com.movieapp.core.domain.usecase

import com.movieapp.core.data.repository.MovieRepository
import com.movieapp.core.domain.mapper.MovieMapper
import com.movieapp.core.domain.model.MovieDomain
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) {
    suspend fun getPopularMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getPopularMovies(page).results.map { movieMapper.mapToDomain(it) }
    }

    suspend fun getTopRatedMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getTopRatedMovies(page).results.map { movieMapper.mapToDomain(it) }
    }

    suspend fun getNowPlayingMovies(page: Int = 1): List<MovieDomain> {
        return movieRepository.getNowPlayingMovies(page).results.map { movieMapper.mapToDomain(it) }
    }

    suspend fun searchMovies(query: String, page: Int = 1): List<MovieDomain> {
        return movieRepository.searchMovies(query, page).results.map { movieMapper.mapToDomain(it) }
    }
} 
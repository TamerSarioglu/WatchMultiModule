package com.movieapp.core.repository

import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse

/**
 * Repository interface for movie-related data operations.
 * This defines the contract for data access regardless of the source.
 */
interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse
    suspend fun getTopRatedMovies(page: Int): MovieResponse
    suspend fun getNowPlayingMovies(page: Int): MovieResponse
    suspend fun searchMovies(query: String, page: Int): MovieResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetail
} 
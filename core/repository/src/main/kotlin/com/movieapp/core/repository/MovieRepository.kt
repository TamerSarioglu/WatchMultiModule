package com.movieapp.core.repository

import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse

/**
 * Repository interface for movie-related data operations.
 * This defines the contract for data access regardless of the source.
 *
 * Implementations should handle:
 * - Network calls
 * - Local caching (future enhancement)
 * - Error handling
 * - Data transformation
 */
interface MovieRepository {
    /**
     * Fetches popular movies from the API
     * @param page Page number for pagination (default: 1)
     * @return MovieResponse containing list of popular movies
     */
    suspend fun getPopularMovies(page: Int = 1): MovieResponse

    /**
     * Fetches top-rated movies from the API
     * @param page Page number for pagination (default: 1)
     * @return MovieResponse containing list of top-rated movies
     */
    suspend fun getTopRatedMovies(page: Int = 1): MovieResponse

    /**
     * Fetches currently playing movies from the API
     * @param page Page number for pagination (default: 1)
     * @return MovieResponse containing list of now-playing movies
     */
    suspend fun getNowPlayingMovies(page: Int = 1): MovieResponse

    /**
     * Searches for movies based on query
     * @param query Search query string
     * @param page Page number for pagination (default: 1)
     * @return MovieResponse containing search results
     */
    suspend fun searchMovies(query: String, page: Int = 1): MovieResponse

    /**
     * Fetches detailed information for a specific movie
     * @param movieId Unique identifier for the movie
     * @return MovieDetail containing comprehensive movie information
     */
    suspend fun getMovieDetails(movieId: Int): MovieDetail
} 
package com.movieapp.core.data.repository

import android.util.Log
import com.movieapp.core.network.api.MovieApi
import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse
import com.movieapp.core.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {

    companion object {
        private const val TAG = "MovieRepositoryImpl"
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return try {
            Log.d(TAG, "Fetching popular movies - page: $page")
            movieApi.getPopularMovies(page)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching popular movies", e)
            throw e
        }
    }

    override suspend fun getTopRatedMovies(page: Int): MovieResponse {
        return try {
            Log.d(TAG, "Fetching top rated movies - page: $page")
            movieApi.getTopRatedMovies(page)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching top rated movies", e)
            throw e
        }
    }

    override suspend fun getNowPlayingMovies(page: Int): MovieResponse {
        return try {
            Log.d(TAG, "Fetching now playing movies - page: $page")
            movieApi.getNowPlayingMovies(page)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching now playing movies", e)
            throw e
        }
    }

    override suspend fun searchMovies(query: String, page: Int): MovieResponse {
        return try {
            Log.d(TAG, "Searching movies - query: $query, page: $page")
            movieApi.searchMovies(query, page)
        } catch (e: Exception) {
            Log.e(TAG, "Error searching movies", e)
            throw e
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return movieApi.getMovieDetails(movieId)
    }
} 
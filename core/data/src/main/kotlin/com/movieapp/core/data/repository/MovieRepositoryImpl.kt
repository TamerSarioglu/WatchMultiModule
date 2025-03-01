package com.movieapp.core.data.repository

import com.movieapp.core.network.api.MovieApi
import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return movieApi.getPopularMovies(page)
    }

    override suspend fun getTopRatedMovies(page: Int): MovieResponse {
        return movieApi.getTopRatedMovies(page)
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return movieApi.getMovieDetails(movieId)
    }
} 
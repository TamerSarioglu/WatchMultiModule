package com.movieapp.core.data.repository

import com.movieapp.core.network.api.MovieApi
import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse
import com.movieapp.core.repository.MovieRepository
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

    override suspend fun getNowPlayingMovies(page: Int): MovieResponse {
        return movieApi.getNowPlayingMovies(page)
    }

    override suspend fun searchMovies(query: String, page: Int): MovieResponse {
        return movieApi.searchMovies(query, page)
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return movieApi.getMovieDetails(movieId)
    }
} 
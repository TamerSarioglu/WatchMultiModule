package com.movieapp.core.network.repository

import com.movieapp.core.network.api.MovieApi
import com.movieapp.core.network.models.Movie
import com.movieapp.core.network.models.MovieDetail
import javax.inject.Inject
import javax.inject.Singleton

interface MovieRepository {
    suspend fun getPopularMovies(page: Int = 1): List<Movie>
    suspend fun getTopRatedMovies(page: Int = 1): List<Movie>
    suspend fun getNowPlayingMovies(page: Int = 1): List<Movie>
    suspend fun searchMovies(query: String, page: Int = 1): List<Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetail
}

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return movieApi.getPopularMovies(page = page).movies
    }

    override suspend fun getTopRatedMovies(page: Int): List<Movie> {
        return movieApi.getTopRatedMovies(page = page).movies
    }

    override suspend fun getNowPlayingMovies(page: Int): List<Movie> {
        return movieApi.getNowPlayingMovies(page = page).movies
    }

    override suspend fun searchMovies(query: String, page: Int): List<Movie> {
        return movieApi.searchMovies(query = query, page = page).movies
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return movieApi.getMovieDetails(movieId = movieId)
    }
} 
package com.movieapp.core.data.repository

import com.movieapp.core.network.models.MovieDetail
import com.movieapp.core.network.models.MovieResponse

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieResponse
    suspend fun getTopRatedMovies(page: Int): MovieResponse
    suspend fun getNowPlayingMovies(page: Int): MovieResponse
    suspend fun searchMovies(query: String, page: Int): MovieResponse
    suspend fun getMovieDetails(movieId: Int): MovieDetail
} 
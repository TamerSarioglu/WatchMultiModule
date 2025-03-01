package com.movieapp.core.domain.model

data class MovieDomain(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val rating: Double,
    val releaseDate: String,
) {
    val posterUrl: String
        get() = "https://image.tmdb.org/t/p/w500$posterPath"
        
    val backdropUrl: String
        get() = "https://image.tmdb.org/t/p/original$backdropPath"
} 
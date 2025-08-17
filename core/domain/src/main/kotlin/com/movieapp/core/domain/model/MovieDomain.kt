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
    private companion object {
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
        private const val POSTER_SIZE = "w500"
        private const val BACKDROP_SIZE = "original"
    }

    val posterUrl: String?
        get() = posterPath?.let { "${BASE_IMAGE_URL}${POSTER_SIZE}$it" }

    val backdropUrl: String?
        get() = backdropPath?.let { "${BASE_IMAGE_URL}${BACKDROP_SIZE}$it" }

    val formattedRating: String
        get() = String.format("%.1f", rating.coerceIn(0.0, 10.0))

    val releaseYear: String
        get() = releaseDate.takeIf { it.length >= 4 }?.take(4) ?: "Unknown"

    val hasValidPoster: Boolean
        get() = !posterPath.isNullOrBlank()

    val hasValidBackdrop: Boolean
        get() = !backdropPath.isNullOrBlank()
}
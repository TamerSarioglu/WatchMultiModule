package com.movieapp.core.domain.model

data class MovieDetailDomain(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val rating: Double,
    val releaseDate: String,
    val genres: List<String>,
    val runtime: Int?,
    val tagline: String?,
    val status: String,
    val budget: Int,
    val revenue: Long,
    val productionCompanies: List<String>,
    val productionCountries: List<String>
) {
    val posterUrl: String
        get() = "https://image.tmdb.org/t/p/w500$posterPath"
        
    val backdropUrl: String
        get() = "https://image.tmdb.org/t/p/original$backdropPath"
        
    val formattedRuntime: String
        get() = runtime?.let { "${it / 60}h ${it % 60}m" } ?: ""
        
    val formattedBudget: String
        get() = "$${budget/1_000_000}M"
        
    val formattedRevenue: String
        get() = "$${revenue/1_000_000}M"
} 
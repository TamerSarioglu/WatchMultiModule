package com.movieapp.core.domain.mapper

import com.movieapp.core.domain.model.ActorDomain
import com.movieapp.core.domain.model.MovieDetailDomain
import com.movieapp.core.domain.model.MovieDomain
import com.movieapp.core.network.models.Cast
import com.movieapp.core.network.models.Movie
import com.movieapp.core.network.models.MovieDetail
import javax.inject.Inject

class MovieMapper @Inject constructor() {
    fun mapToDomain(movie: Movie): MovieDomain {
        return MovieDomain(
            id = movie.id,
            title = movie.title,
            overview = movie.overview,
            posterPath = movie.posterPath,
            backdropPath = movie.backdropPath,
            rating = movie.rating,
            releaseDate = movie.releaseDate
        )
    }

    fun mapToDomain(movieDetail: MovieDetail): MovieDetailDomain {
        return MovieDetailDomain(
            id = movieDetail.id,
            title = movieDetail.title,
            overview = movieDetail.overview,
            posterPath = movieDetail.posterPath,
            backdropPath = movieDetail.backdropPath,
            rating = movieDetail.voteAverage,
            releaseDate = movieDetail.releaseDate,
            genres = movieDetail.genres.map { it.name },
            runtime = movieDetail.runtime,
            tagline = movieDetail.tagline,
            status = movieDetail.status,
            budget = movieDetail.budget,
            revenue = movieDetail.revenue,
            productionCompanies = movieDetail.productionCompanies.map { it.name },
            productionCountries = movieDetail.productionCountries.map { it.name },
            actors = mapCastToActors(movieDetail.credits?.cast ?: emptyList())
        )
    }
    
    private fun mapCastToActors(cast: List<Cast>): List<ActorDomain> {
        return cast.take(10).map { castMember ->
            ActorDomain(
                id = castMember.id,
                name = castMember.name,
                character = castMember.character,
                profilePath = castMember.profilePath
            )
        }
    }
} 
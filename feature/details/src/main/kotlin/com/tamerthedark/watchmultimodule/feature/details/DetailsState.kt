package com.tamerthedark.watchmultimodule.feature.details

import com.movieapp.core.domain.model.MovieDetailDomain

data class DetailsState(
    val movieDetail: MovieDetailDomain? = null,
    val isLoading: Boolean = false,
    val error: String? = null
) 
package com.sun_asterisk.clean_architecture_sample2.domain.model

data class Movie(
    val movieID: Int,
    val movieTitle: String,
    val movieOverView: String,
    val moviePosterPath: String,
    val movieBackdropPath: String,
    val movieVoteAverage: Double,
    val movieReleaseDate: String
)

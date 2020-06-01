package com.sun_asterisk.clean_architecture_sample2.domain.repository

import com.sun_asterisk.clean_architecture_sample2.domain.model.Movie

interface MoviesRepository {

    suspend fun getMovies(category: String): List<Movie>
}

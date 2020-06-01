package com.sun_asterisk.clean_architecture_sample2.data.repository

import com.sun_asterisk.clean_architecture_sample2.data.remote.MovieService
import com.sun_asterisk.clean_architecture_sample2.data.remote.response.MoviesResponse
import com.sun_asterisk.clean_architecture_sample2.domain.model.Movie
import com.sun_asterisk.clean_architecture_sample2.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val movieService: MovieService) : MoviesRepository {

    override suspend fun getMovies(category: String): List<Movie> {
        return movieService.getMovies(category).movies.map(MoviesResponse.MovieEntity::map)
    }
}

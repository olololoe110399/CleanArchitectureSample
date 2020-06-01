package com.sun_asterisk.clean_architecture_sample2.domain.usecase

import com.sun_asterisk.clean_architecture_sample2.domain.model.Movie
import com.sun_asterisk.clean_architecture_sample2.domain.repository.MoviesRepository
import com.sun_asterisk.clean_architecture_sample2.domain.usecase.base.UseCase

class GetMoviesUseCase constructor(
    private val moviesRepository: MoviesRepository
) : UseCase<List<Movie>, String>() {

    override suspend fun run(params: String): List<Movie> {
        return moviesRepository.getMovies(params)
    }
}

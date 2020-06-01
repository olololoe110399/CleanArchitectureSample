package com.sun_asterisk.clean_architecture_sample2.data.remote

import com.sun_asterisk.clean_architecture_sample2.data.remote.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String
    ): MoviesResponse
}

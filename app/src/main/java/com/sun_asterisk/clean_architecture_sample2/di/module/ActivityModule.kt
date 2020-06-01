package com.sun_asterisk.clean_architecture_sample2.di.module

import com.sun_asterisk.clean_architecture_sample2.presentation.movies.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MovieModule = module {

    viewModel { MoviesViewModel(get()) }

    single { createGetMoviesUseCase(get()) }

    single { createMovieRepository(get()) }
}

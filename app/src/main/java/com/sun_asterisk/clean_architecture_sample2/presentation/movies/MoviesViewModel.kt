package com.sun_asterisk.clean_architecture_sample2.presentation.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun_asterisk.clean_architecture_sample2.domain.model.Movie
import com.sun_asterisk.clean_architecture_sample2.domain.usecase.GetMoviesUseCase
import com.sun_asterisk.clean_architecture_sample2.domain.usecase.base.UseCaseResponse
import com.sun_asterisk.clean_architecture_sample2.presentation.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

internal class MoviesViewModel(
    private val useCase: GetMoviesUseCase
) : BaseViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    @ExperimentalCoroutinesApi
    fun getMovies(category: String) =
        useCase.invoke(category, object : UseCaseResponse<List<Movie>> {
            override fun onSuccess(result: List<Movie>) {
                _movies.value = result
            }

            override fun onError(errorMsg: String?) {
                _messageToast.value = errorMsg
                Log.i("ERORRRR",errorMsg.toString())

            }
        })
}

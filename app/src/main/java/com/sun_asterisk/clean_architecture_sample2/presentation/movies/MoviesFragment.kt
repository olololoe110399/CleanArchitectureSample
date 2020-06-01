package com.sun_asterisk.clean_architecture_sample2.presentation.movies

import androidx.lifecycle.Observer
import com.sun_asterisk.clean_architecture_sample2.R
import com.sun_asterisk.clean_architecture_sample2.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

internal class MoviesFragment private constructor() : BaseFragment<MoviesViewModel>() {
    private val adapter = MovieAdapter()

    override val layoutResource: Int get() = R.layout.fragment_movies

    override val viewModel: MoviesViewModel by viewModel()

    @ExperimentalCoroutinesApi
    override fun initComponents() {
        moviesRecyclerView.adapter = adapter
        viewModel.getMovies(getString(R.string.title_popular))
    }

    override fun observeData() = with(viewModel) {
        super.observeData()
        movies.observe(viewLifecycleOwner, Observer(adapter::submitList))
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}

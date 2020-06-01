package com.sun_asterisk.clean_architecture_sample2.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.sun_asterisk.clean_architecture_sample2.BR
import com.sun_asterisk.clean_architecture_sample2.R
import com.sun_asterisk.clean_architecture_sample2.databinding.ItemMovieBinding
import com.sun_asterisk.clean_architecture_sample2.domain.model.Movie
import com.sun_asterisk.clean_architecture_sample2.presentation.base.BaseRecyclerAdapter
import com.sun_asterisk.clean_architecture_sample2.presentation.base.BaseViewHolder

class MovieAdapter :
    BaseRecyclerAdapter<Movie, MovieAdapter.ViewHolder>(MovieDiffUtilCallback()) {
    var onItemClick: (Movie) -> Unit = { _ -> }

    override fun getItemViewType(position: Int) = R.layout.item_movie

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemMovieBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    class ViewHolder(
        itemView: ViewDataBinding,
        private val onItemClick: (Movie) -> Unit
    ) : BaseViewHolder<Movie>(binding = itemView) {

        override fun onItemClickListener(itemData: Movie) = onItemClick(itemData)

        override fun getVariableID() = BR.movie
    }

    class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.movieID == newItem.movieID

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }
}

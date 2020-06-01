package com.sun_asterisk.clean_architecture_sample2.presentation.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>>(
    callback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(callback) {

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.onBindData(getItem(position))

    override fun submitList(items: List<T>?) {
        super.submitList(items ?: emptyList())
    }

    fun insertData(tasks: List<T>) {
        submitList(mutableListOf<T>().apply { addAll(tasks) })
    }
}

package com.sun_asterisk.clean_architecture_sample2.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sun_asterisk.clean_architecture_sample2.R

@BindingAdapter("bindImage")
fun ImageView.loadImageUrl(imagePath: String?) {
    if (imagePath.isNullOrEmpty()) {
        setImageResource(
            listOf(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark).random()
        )
        return
    }
    Glide.with(context)
        .load(Constant.BASE_URL_IMAGE + imagePath)
        .placeholder(
            listOf(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark).random()
        )
        .into(this)
}

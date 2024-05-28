package com.hanto.newsapp.ui.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hanto.newsapp.R

//확장함수
fun ImageView.load(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this)
            .load(url)
            .placeholder(R.color.gray)
            .error(R.drawable.ic_image_not_supported)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_image_not_supported)
    }
}
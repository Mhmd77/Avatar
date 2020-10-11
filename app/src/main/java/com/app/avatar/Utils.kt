package com.app.avatar

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.avatar.data.model.MovieItem
import com.app.avatar.ui.list.MovieAdapter
import com.bumptech.glide.Glide

@BindingAdapter("movieList")
fun RecyclerView.movieList(items: List<MovieItem>?) {
    items?.let {
        (adapter as MovieAdapter).submitList(it)
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}
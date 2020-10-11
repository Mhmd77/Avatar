package com.app.avatar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class MovieItem(
    @Json(name = "imdbID")
    @PrimaryKey
    val id: String,
    @Json(name = "Title")
    val title: String,
    @Json(name = "Year")
    val year: String,
    @Json(name = "Type")
    val type: String,
    @Json(name = "Poster")
    val poster: String
)

@JsonClass(generateAdapter = true)
data class MovieListHolder(
    @Json(name = "Search")
    val search: List<MovieItem>,
    val totalResults: Int,
    @Json(name = "Response")
    val response: String
)
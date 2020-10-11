package com.app.avatar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "table_movie")
data class Movie(
    @Json(name = "imdbID")
    @PrimaryKey
    val id: String,
    @Json(name = "Title")
    val title: String,
    @Json(name = "Year")
    val year: String,
    @Json(name = "Type")
    val type: String,
    @Json(name = "Rated")
    val rated: String,
    @Json(name = "Released")
    val released: String,
    @Json(name = "Genre")
    val genre: String,
    @Json(name = "Actors")
    val acters: String,
    @Json(name = "Poster")
    val poster: String
)
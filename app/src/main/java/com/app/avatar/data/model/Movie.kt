package com.app.avatar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "table_movie")
data class Movie(
    @Json(name = "imdbId")
    @PrimaryKey
    private val id: String,
    @Json(name = "Title")
    private val title: String,
    @Json(name = "Year")
    private val year: String,
    @Json(name = "Type")
    private val type: String,
    @Json(name = "Rated")
    private val rated: String,
    @Json(name = "Released")
    private val released: String,
    @Json(name = "Genre")
    private val genre: String,
    @Json(name = "Actors")
    private val acters: String
)
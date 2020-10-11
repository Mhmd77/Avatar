package com.app.avatar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class MovieItem(
    @Json(name = "imdbId")
    @PrimaryKey
    private val id: String,
    @Json(name = "Title")
    private val title: String,
    @Json(name = "year")
    private val year: String,
    @Json(name = "type")
    private val type: String,
    @Json(name = "poster")
    private val poster: String
)
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
    @Json(name = "Year")
    private val year: String,
    @Json(name = "Type")
    private val type: String,
    @Json(name = "Poster")
    private val poster: String
)
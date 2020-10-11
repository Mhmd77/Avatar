package com.app.avatar.data.source.remote

import com.app.avatar.data.model.Movie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

object MovieApiService {
    val api: MovieApi = Network.retrofit.create(MovieApi::class.java)
}

interface MovieApi {
    @GET
    fun getMovieById(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String = Network.API_KEY
    ): Deferred<Movie>
}


package com.app.avatar.data.source.remote

import com.app.avatar.data.model.Movie
import com.app.avatar.data.model.MovieItem
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

object MovieItemApiService {
    val api: MovieItemApi = Network.retrofit.create(MovieItemApi::class.java)
}

interface MovieItemApi {
    @GET
    fun getMoviesListAsync(
        @Query("apiKey") apiKey: String = Network.API_KEY,
        @Query("s") search: String = Network.SEARCH
    ): Deferred<List<MovieItem>>
}


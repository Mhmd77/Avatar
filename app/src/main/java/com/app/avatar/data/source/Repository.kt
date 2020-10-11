package com.app.avatar.data.source

import androidx.lifecycle.LiveData
import com.app.avatar.data.model.MovieItem
import com.app.avatar.data.source.local.Database
import com.app.avatar.data.source.remote.MovieItemApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class Repository(
    private val database: Database
) {

    suspend fun refreshMovieItems() {
        return try {
            val result = MovieItemApiService.api.getMoviesListAsync().await()
            refreshLocalDataSource(result)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private suspend fun refreshLocalDataSource(marvelList: List<MovieItem>) =
        withContext(Dispatchers.IO) {
            database.movieItemDao().clear()
            database.movieItemDao().insertAll(marvelList)
        }

    fun observeList(): LiveData<List<MovieItem>> = database.movieItemDao().observeAll()
}
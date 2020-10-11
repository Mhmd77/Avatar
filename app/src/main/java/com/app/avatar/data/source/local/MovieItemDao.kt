package com.app.avatar.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.avatar.data.model.Movie
import com.app.avatar.data.model.MovieItem

@Dao
interface MovieItemDao {
    @Insert
    suspend fun insertAll(items: List<MovieItem>)

    @Query("delete from MOVIEITEM")
    suspend fun clear()

    @Query("select * from MOVIEITEM")
    fun observeAll(): LiveData<List<MovieItem>>
}
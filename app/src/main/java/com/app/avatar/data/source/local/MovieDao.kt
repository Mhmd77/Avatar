package com.app.avatar.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.avatar.data.model.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun insertAll(items: List<Movie>)

    @Query("delete from table_movie where id = :id")
    suspend fun deleteMovie(id: String)

    @Query("select * from table_movie where id = :id")
    suspend fun getMovie(id: String): Movie
}
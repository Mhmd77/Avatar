package com.app.avatar.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.avatar.data.model.Movie
import com.app.avatar.data.model.MovieItem

@Database(
    entities = [MovieItem::class, Movie::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun movieItemDao(): MovieItemDao
    abstract fun movieDao(): MovieDao
}
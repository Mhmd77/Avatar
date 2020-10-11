package com.app.avatar

import android.content.Context
import androidx.room.Room
import com.app.avatar.data.source.Repository
import com.app.avatar.data.source.local.Database

object ServiceLocator {
    private var database: Database? = null

    fun provideRepository(context: Context): Repository {
        return Repository(
            provideDatabase(context)
        )
    }

    private fun provideDatabase(context: Context): Database {
        synchronized(this) {
            return database ?: createDatabase(context)
        }

    }

    private fun createDatabase(context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "AvatarDatabase"
        ).fallbackToDestructiveMigration()
            .build().also {
                database = it
            }
    }

}
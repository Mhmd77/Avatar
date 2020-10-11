package com.app.avatar.data.source.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LocalDataSource(private val database: Database) {
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Default

}
package com.app.avatar.data.source

import androidx.lifecycle.LiveData
import com.app.avatar.data.source.local.LocalDataSource
import com.app.avatar.data.source.remote.RemoteDataSource

class Repository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

}
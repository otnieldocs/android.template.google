package com.otnieldocs.googletemplate.repository

import com.otnieldocs.googletemplate.repository.local.AppLocalDataSource
import com.otnieldocs.googletemplate.repository.remote.AppRemoteDataSource

class AppRepository(
    private val remoteDataSource: AppRemoteDataSource,
    private val localDataSource: AppLocalDataSource
) {
    suspend fun saveFFHomeEnabled(enabled: Boolean) = localDataSource.saveFFHomeEnabled(enabled)

    fun loadFFHomeEnabled() = localDataSource.ffHomeEnabled
}
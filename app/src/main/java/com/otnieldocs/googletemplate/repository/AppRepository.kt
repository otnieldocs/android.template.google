package com.otnieldocs.googletemplate.repository

import com.otnieldocs.googletemplate.repository.local.AppLocalDataSource
import com.otnieldocs.googletemplate.repository.remote.AppRemoteDataSource

class AppRepository(
    val remoteDataSource: AppRemoteDataSource,
    val localDataSource: AppLocalDataSource
) {
}
package com.otnieldocs.googletemplate.repository.local

import javax.inject.Inject

/**
 * Local repository will be combination of shared preference and Room db
 */
class AppLocalDataSource @Inject constructor(
    private val preference: AppPreference,
    private val database: AppDatabase
) {
}
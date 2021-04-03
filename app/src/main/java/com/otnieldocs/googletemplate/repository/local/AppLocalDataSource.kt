package com.otnieldocs.googletemplate.repository.local

/**
 * Local repository will be combination of shared preference and Room db
 */
class AppLocalDataSource(
    private val preference: AppPreference,
    private val database: AppDatabase
) {
}
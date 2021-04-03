package com.otnieldocs.googletemplate.repository.local

import javax.inject.Inject

/**
 * Local repository will be combination of shared preference and Room db
 */
class AppLocalDataSource @Inject constructor(
    private val preference: AppPreference,
    private val database: AppDatabase
) {
    val ffHomeEnabled = preference.isEnabled(AppPreferenceKeys.FF_HOME_ENABLED)
    val hhLoginEnabled = preference.isEnabled(AppPreferenceKeys.FF_LOGIN_ENABLED)

    suspend fun saveFFHomeEnabled(enabled: Boolean) =
        preference.saveFeatureFlag(AppPreferenceKeys.FF_HOME_ENABLED, enabled)

    suspend fun saveFFLoginEnabled(enabled: Boolean) =
        preference.saveFeatureFlag(AppPreferenceKeys.FF_LOGIN_ENABLED, enabled)
}
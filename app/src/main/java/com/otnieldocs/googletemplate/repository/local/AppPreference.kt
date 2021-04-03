package com.otnieldocs.googletemplate.repository.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreference constructor(
    private val dataStore: DataStore<Preferences>
) {
    fun isEnabled(
        flagKey: Preferences.Key<Boolean>
    ): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[flagKey] ?: false
    }

    suspend fun saveFeatureFlag(flagKey: Preferences.Key<Boolean>, enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[flagKey] = enabled
        }
    }
}

object AppPreferenceKeys {
    val FF_HOME_ENABLED = booleanPreferencesKey("app_home_enabled")
    val FF_LOGIN_ENABLED = booleanPreferencesKey("app_login_enabled")
}
package com.otnieldocs.googletemplate.repository.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreference(
    private val dataStore: DataStore<Preferences>
) {
    fun isEnabled(
        flagKey: Preferences.Key<Boolean>
    ): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[flagKey] ?: false
    }

}

object AppPreferenceKeys {
    val FF_HOME_ENABLED = booleanPreferencesKey("app_home_enabled")
    val FF_LOGIN_ENABLED = booleanPreferencesKey("app_login_enabled")
}
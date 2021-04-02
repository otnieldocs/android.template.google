package com.otnieldocs.common

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig

class FeatureFlag(private val flags: List<String>) {
    private fun getPreference(
        context: Context
    ) = PreferenceManager.getDefaultSharedPreferences(context)

    private fun getFeatureFlag(key: String) = Firebase.remoteConfig.getBoolean(key)

    private fun saveFlags(preferences: SharedPreferences) {
        for (flag in flags) {
            val newFlag = getFeatureFlag(flag)
            preferences.edit().putBoolean(flag, newFlag).apply()
        }
    }

    private fun loadFlags(preferences: SharedPreferences): Map<String, Boolean> {
        val newFlags = mutableMapOf<String, Boolean>()

        for (flag in flags) {
            newFlags[flag] = preferences.getBoolean(flag, false)
        }

        return newFlags
    }

    fun build(
        activity: AppCompatActivity,
        onCompleted: (Map<String, Boolean>)->Unit
    ) {
        val preferences = getPreference(activity)

        Firebase.remoteConfig.fetchAndActivate().addOnCompleteListener(activity) { task ->
            if (task.isSuccessful) {
                saveFlags(preferences)
            }

            val newFlags = loadFlags(preferences)
            onCompleted.invoke(newFlags)
        }
    }
}
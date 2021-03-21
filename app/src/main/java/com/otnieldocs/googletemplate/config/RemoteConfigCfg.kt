package com.otnieldocs.googletemplate.config

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.otnieldocs.googletemplate.BuildConfig

object RemoteConfigCfg {
    private fun getConfig() = Firebase.remoteConfig

    fun build() {
        val remoteConfig = getConfig()

        // set cache time to 0 if in debug mode
        val cacheExpiration = if (BuildConfig.DEBUG.not()) {
            BuildConfig.REMOTE_CONFIG_MINIMUM_FETCH_INTERVAL_IN_SECOND.toLong()
        } else 0

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = cacheExpiration
        }

        remoteConfig.setConfigSettingsAsync(configSettings)
    }
}
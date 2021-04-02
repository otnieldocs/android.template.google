package com.otnieldocs.googletemplate.config

import androidx.appcompat.app.AppCompatActivity
import com.otnieldocs.common.FeatureFlag

object FeatureFlagCfg {
    fun build(activity: AppCompatActivity, handler: (Map<String, Boolean>)->Unit) {
        val flags = listOf(
            FLAG_APP_HOME,
            FLAG_APP_LOGIN
        )

        if (flags.isNotEmpty()) {
            FeatureFlag(flags).build(activity, handler)
        }
    }

    const val FLAG_APP_HOME = "app_home_enabled"
    const val FLAG_APP_LOGIN = "app_login_enabled"
}
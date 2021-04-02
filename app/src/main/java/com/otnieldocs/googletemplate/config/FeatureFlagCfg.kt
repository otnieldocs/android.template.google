package com.otnieldocs.googletemplate.config

import androidx.appcompat.app.AppCompatActivity
import com.otnieldocs.common.FeatureFlag
import com.otnieldocs.googletemplate.AppConstant.FLAG_APP_HOME
import com.otnieldocs.googletemplate.AppConstant.FLAG_APP_LOGIN

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
}
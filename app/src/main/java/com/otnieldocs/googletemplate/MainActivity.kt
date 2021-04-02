package com.otnieldocs.googletemplate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.otnieldocs.appcontract.AppNavigation
import com.otnieldocs.appcontract.dto.AppHomeScreenArgDto
import com.otnieldocs.appcontract.dto.AppLoginScreenArgDto
import com.otnieldocs.common.DeepLink
import com.otnieldocs.googletemplate.AppConstant.FLAG_APP_HOME
import com.otnieldocs.googletemplate.AppConstant.FLAG_APP_LOGIN
import com.otnieldocs.googletemplate.AppConstant.PAGE_HOME
import com.otnieldocs.googletemplate.AppConstant.PAGE_LOGIN
import com.otnieldocs.googletemplate.config.FeatureFlagCfg

class MainActivity : AppCompatActivity(), AppNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // todo: use view flipper to show loading screen
        FeatureFlagCfg.build(this) { featureFlags ->
            val tv = findViewById<TextView>(R.id.simple_textview)
            tv.text = Firebase.remoteConfig.getBoolean(FLAG_APP_HOME).toString()

            DeepLink().addRoute(PAGE_HOME) {
                toHomeScreen(
                    featureFlags[FLAG_APP_HOME] ?: true,
                    AppHomeScreenArgDto()
                )
            }.addRoute(PAGE_LOGIN) {
                toLoginScreen(
                    featureFlags[FLAG_APP_LOGIN] ?: true,
                    AppLoginScreenArgDto()
                )
            }.build(intent?.data)
        }
    }

    override fun toSplashScreen() {
        // todo: not implemented yet
    }

    override fun toHomeScreen(isEnable: Boolean, args: AppHomeScreenArgDto) {
        if (isEnable) {
            // todo: jump to target fragment
        } else {
            // todo: show have no permission
        }
    }

    override fun toLoginScreen(isEnable: Boolean, args: AppLoginScreenArgDto) {
        if (isEnable) {
             // todo: jump to target fragment
        } else {
            // todo: show have no permission
        }
    }
}
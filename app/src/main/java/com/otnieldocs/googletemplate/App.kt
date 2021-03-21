package com.otnieldocs.googletemplate

import android.app.Application
import com.otnieldocs.googletemplate.config.RemoteConfigCfg

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RemoteConfigCfg.build()
    }
}
package com.otnieldocs.googletemplate

import com.otnieldocs.googletemplate.config.RemoteConfigCfg
import com.otnieldocs.googletemplate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        RemoteConfigCfg.build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder()
        .applicationContext(this)
        .build()
        .also {
            it.inject(this)
        }
}
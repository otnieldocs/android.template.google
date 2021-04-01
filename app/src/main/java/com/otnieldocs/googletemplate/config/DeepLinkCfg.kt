package com.otnieldocs.googletemplate.config

import android.net.Uri
import android.util.Log
import com.otnieldocs.common.DeepLink

object DeepLinkCfg {
    fun build(data: Uri?) {
        DeepLink()
            .addRoute("home") {
                Log.d("ROUTE_CONFIG", "Visit home")
            }
            .addRoute("login") {
                Log.d("ROUTE_CONFIG", "Visit login")
            }
            .build(data)
    }
}
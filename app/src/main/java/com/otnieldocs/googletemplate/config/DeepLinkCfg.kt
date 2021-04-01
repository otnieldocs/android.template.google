package com.otnieldocs.googletemplate.config

import android.net.Uri
import android.util.Log

object DeepLinkCfg {
    fun build(data: Uri?) {
        when(getPage(data)) {
            // todo : replace "home" string with actual module name
            "home" -> Log.d("ROUTE_CONFIG", "Visit home page")
            else -> Log.d("ROUTE_CONFIG", "Incompatible deeplink route format")
        }
    }

    private fun getPage(data: Uri?) = data?.getQueryParameter(KEY_PAGE) ?: ""

    private const val KEY_PAGE = "page"
}
package com.otnieldocs.common

import android.net.Uri

class DeepLink {
    private val routeMap = mutableMapOf<String, (()->Unit)?>()

    fun addRoute(page: String, routeTo: (()->Unit)?): DeepLink {
        routeMap[page] = routeTo

        return this
    }

    fun build(data: Uri?) {
        val page = getPage(data)

        routeMap[page]?.invoke()
    }

    private fun getPage(data: Uri?) = data?.getQueryParameter(KEY_PAGE) ?: ""

    companion object {
        private const val KEY_PAGE = "page"
    }
}
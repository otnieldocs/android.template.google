package com.otnieldocs.appcontract

import com.otnieldocs.appcontract.dto.AppHomeScreenArgDto
import com.otnieldocs.appcontract.dto.AppLoginScreenArgDto

interface AppNavigation {
    fun toSplashScreen()
    fun toHomeScreen(isEnable: Boolean, args: AppHomeScreenArgDto)
    fun toLoginScreen(isEnable: Boolean, args: AppLoginScreenArgDto)
}
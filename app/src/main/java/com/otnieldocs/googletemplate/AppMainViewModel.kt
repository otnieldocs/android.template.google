package com.otnieldocs.googletemplate

import com.otnieldocs.googletemplate.repository.AppRepository
import javax.inject.Inject

class AppMainViewModel @Inject constructor(
    private val repository: AppRepository
) {
    suspend fun saveFeatureFlag() {
        repository.saveFFHomeEnabled(true)
    }
}
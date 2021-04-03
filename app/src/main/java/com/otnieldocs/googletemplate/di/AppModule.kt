package com.otnieldocs.googletemplate.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.otnieldocs.googletemplate.config.appDataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideDataStore(
        applicationContext: Context
    ): DataStore<Preferences> = applicationContext.appDataStore
}
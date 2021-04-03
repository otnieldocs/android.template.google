package com.otnieldocs.googletemplate.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.otnieldocs.googletemplate.config.appDataStore
import com.otnieldocs.googletemplate.repository.local.AppDatabase
import com.otnieldocs.googletemplate.repository.local.AppLocalDataSource
import com.otnieldocs.googletemplate.repository.local.AppPreference
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

    @Provides
    @Singleton
    fun provideAppPreference(
        dataStore: DataStore<Preferences>
    ): AppPreference = AppPreference(dataStore)

    // todo: provide AppDatabase, will use Room for database
    @Provides
    @Singleton
    fun provideAppLocalDataSource(
        preference: AppPreference
    ): AppLocalDataSource = AppLocalDataSource(preference, AppDatabase())
}
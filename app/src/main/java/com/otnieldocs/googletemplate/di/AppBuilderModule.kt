package com.otnieldocs.googletemplate.di

import com.otnieldocs.googletemplate.AppMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBuilderModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): AppMainActivity
}
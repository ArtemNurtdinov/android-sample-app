package com.nefrit.app.di

import android.app.Application
import android.content.Context
import com.nefrit.app.App
import com.nefrit.core_di.scope.ApplicationScope
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @ApplicationScope
    @Binds
    fun bindApplication(application: App): Application

    @ApplicationScope
    @Binds
    fun bindContext(application: App): Context
}
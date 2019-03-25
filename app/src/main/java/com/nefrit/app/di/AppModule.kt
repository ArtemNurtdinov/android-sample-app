package com.nefrit.app.di

import android.content.Context
import com.nefrit.core.di.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {

    @ApplicationScope
    @Provides
    fun provideContext(): Context = context
}
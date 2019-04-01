package com.nefrit.common.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: com.nefrit.common.di.ViewModelFactory): ViewModelProvider.Factory
}
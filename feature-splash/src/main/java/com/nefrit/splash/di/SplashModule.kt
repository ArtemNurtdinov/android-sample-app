package com.nefrit.splash.di

import androidx.lifecycle.ViewModel
import com.nefrit.common.di.ViewModelKey
import com.nefrit.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun provideSplashViewModel(viewModel: SplashViewModel): ViewModel
}
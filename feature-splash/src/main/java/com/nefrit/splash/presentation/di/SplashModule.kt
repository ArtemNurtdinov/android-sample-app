package com.nefrit.splash.presentation.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nefrit.common.di.ViewModelKey
import com.nefrit.common.di.ViewModelModule
import com.nefrit.splash.SplashRouter
import com.nefrit.splash.presentation.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
class SplashModule {

    @Provides
    internal fun provideScannerViewModel(activity: AppCompatActivity, factory: ViewModelProvider.Factory): SplashViewModel {
        return ViewModelProviders.of(activity, factory).get(SplashViewModel::class.java)
    }

    @Provides
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun provideSignInViewModel(router: SplashRouter): ViewModel {
        return SplashViewModel(router)
    }
}
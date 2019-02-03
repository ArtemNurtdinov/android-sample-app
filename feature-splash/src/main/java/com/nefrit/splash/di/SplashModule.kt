package com.nefrit.splash.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nefrit.splash.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    internal fun provideSplashViewModel(activity: AppCompatActivity, factory: SplashViewModelFactory): SplashViewModel {
        return ViewModelProviders.of(activity, factory).get(SplashViewModel::class.java)
    }
}
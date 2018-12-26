package com.nefrit.main.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nefrit.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    internal fun provideMainViewModel(activity: AppCompatActivity, factory: MainViewModelFactory): MainViewModel {
        return ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)
    }
}
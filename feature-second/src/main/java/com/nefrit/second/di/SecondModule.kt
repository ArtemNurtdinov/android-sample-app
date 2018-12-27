package com.nefrit.second.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.nefrit.second.SecondViewModel
import dagger.Module
import dagger.Provides

@Module
class SecondModule {

    @Provides
    internal fun provideMainViewModel(activity: AppCompatActivity, factory: SecondViewModelFactory): SecondViewModel {
        return ViewModelProviders.of(activity, factory).get(SecondViewModel::class.java)
    }
}
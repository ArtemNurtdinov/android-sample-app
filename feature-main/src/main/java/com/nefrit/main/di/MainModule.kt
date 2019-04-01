package com.nefrit.main.di

import androidx.lifecycle.ViewModel
import com.nefrit.common.di.ViewModelKey
import com.nefrit.common.di.ViewModelModule
import com.nefrit.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel
}
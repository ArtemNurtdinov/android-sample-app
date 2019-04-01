package com.nefrit.second.di

import androidx.lifecycle.ViewModel
import com.nefrit.common.di.ViewModelKey
import com.nefrit.common.di.ViewModelModule
import com.nefrit.second.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class SecondModule {

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    internal abstract fun provideSecondViewModel(viewModel: SecondViewModel): ViewModel
}
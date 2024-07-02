package com.nefrit.users.presentation.list.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.di.viewmodel.ViewModelKey
import com.nefrit.common.di.viewmodel.ViewModelModule
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.users.presentation.list.UsersViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class UsersModule {

    @Provides
    fun provideUsersViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): UsersViewModel {
        return ViewModelProvider(fragment, factory)[UsersViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    fun provideViewModel(interactor: UserInteractor, resourceManager: ResourceManager): ViewModel {
        return UsersViewModel(interactor, resourceManager)
    }
}
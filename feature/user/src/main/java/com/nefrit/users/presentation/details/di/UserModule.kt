package com.nefrit.users.presentation.details.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.di.viewmodel.ViewModelKey
import com.nefrit.common.di.viewmodel.ViewModelModule
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.presentation.details.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class UserModule {

    @Provides
    fun provideContactDetailsViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): UserViewModel {
        return ViewModelProvider(fragment, factory)[UserViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun provideViewModel(interactor: UserInteractor, userId: Long, resourceManager: ResourceManager): ViewModel {
        return UserViewModel(interactor, userId, resourceManager)
    }
}
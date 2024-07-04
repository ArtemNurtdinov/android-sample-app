package com.nefrit.users.presentation.details.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.resources.ResourceManager
import com.nefrit.data.network.NetworkApiCreator
import com.nefrit.ui.viewmodel.ViewModelKey
import com.nefrit.ui.viewmodel.ViewModelModule
import com.nefrit.users.data.UserRepositoryImpl
import com.nefrit.users.data.network.UserApi
import com.nefrit.users.data.network.UserApiImpl
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.UserRepository
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

    @Provides
    fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository = userRepository

    @Provides
    fun provideUserInteractor(repository: UserRepository): UserInteractor {
        return UserInteractor(repository)
    }

    @Provides
    fun provideUserApi(apiCreator: NetworkApiCreator): UserApi {
        return UserApiImpl()
    }
}
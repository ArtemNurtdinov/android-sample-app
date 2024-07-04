package com.nefrit.users.presentation.list.di

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
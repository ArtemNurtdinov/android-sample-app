package com.nefrit.users.presentation.list.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nefrit.common.di.viewmodel.ViewModelKey
import com.nefrit.common.di.viewmodel.ViewModelModule
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.users.UsersRouter
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
    fun provideMainViewModel(activity: AppCompatActivity, factory: ViewModelProvider.Factory): UsersViewModel {
        return ViewModelProviders.of(activity, factory).get(UsersViewModel::class.java)
    }

    @Provides
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    fun provideSignInViewModel(interactor: UserInteractor, router: UsersRouter): ViewModel {
        return UsersViewModel(interactor, router)
    }
}
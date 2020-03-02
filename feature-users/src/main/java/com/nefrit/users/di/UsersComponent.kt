package com.nefrit.users.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.users.presentation.UsersActivity
import dagger.BindsInstance
import dagger.Component
import jp.co.soramitsu.core_di.scope.FeatureScope

@Component(
    dependencies = [
        UsersDependencies::class
    ],
    modules = [
        UsersModule::class
    ]
)
@FeatureScope
interface UsersComponent {

    companion object {

        fun init(activity: AppCompatActivity, deps: UsersDependencies): UsersComponent {
            return DaggerUsersComponent.factory().create(activity, deps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: AppCompatActivity,
            deps: UsersDependencies
        ): UsersComponent
    }

    fun inject(activity: UsersActivity)
}
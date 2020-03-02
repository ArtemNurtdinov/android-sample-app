package com.nefrit.user.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.user.presentation.UserActivity
import dagger.BindsInstance
import dagger.Component
import jp.co.soramitsu.core_di.scope.FeatureScope

@Component(
    dependencies = [
        UserDependencies::class
    ],
    modules = [
        UserModule::class
    ]
)
@FeatureScope
interface UserComponent {

    companion object {

        fun init(activity: AppCompatActivity, userId: Int, deps: UserDependencies): UserComponent {
            return DaggerUserComponent.factory().create(activity, userId, deps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: AppCompatActivity,
            @BindsInstance userId: Int,
            deps: UserDependencies
        ): UserComponent
    }

    fun inject(activity: UserActivity)
}
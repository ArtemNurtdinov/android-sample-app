package com.nefrit.users.presentation.details.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.ScreenScope
import com.nefrit.users.di.UserFeatureDependencies
import com.nefrit.users.presentation.details.UserFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        UserFeatureDependencies::class
    ],
    modules = [
        UserModule::class
    ]
)
@ScreenScope
interface UserComponent {

    companion object {

        fun create(fragment: Fragment, userId: Long, dependencies: UserFeatureDependencies): UserComponent {
            return DaggerUserComponent.factory()
                .create(fragment, userId, dependencies)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment,
            @BindsInstance userId: Long,
            dependencies: UserFeatureDependencies
        ): UserComponent
    }

    fun inject(fragment: UserFragment)
}
package com.nefrit.users.presentation.list.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.ScreenScope
import com.nefrit.users.di.UserFeatureDependencies
import com.nefrit.users.presentation.list.UsersFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        UserFeatureDependencies::class
    ],
    modules = [
        UsersModule::class
    ]
)
@ScreenScope
interface UsersComponent {

    companion object {

        fun create(fragment: Fragment, dependencies: UserFeatureDependencies): UsersComponent {
            return DaggerUsersComponent.factory()
                .create(fragment, dependencies)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: UserFeatureDependencies
        ): UsersComponent
    }

    fun inject(fragment: UsersFragment)
}
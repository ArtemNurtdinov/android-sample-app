package com.nefrit.users.presentation.details.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.scope.ScreenScope
import com.nefrit.users.presentation.details.UserFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UserModule::class
    ]
)
@ScreenScope
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment,
            @BindsInstance userId: Int
        ): UserComponent
    }

    fun inject(fragment: UserFragment)
}
package com.nefrit.users.presentation.list.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.scope.ScreenScope
import com.nefrit.users.presentation.list.UsersFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UsersModule::class
    ]
)
@ScreenScope
interface UsersComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment
        ): UsersComponent
    }

    fun inject(fragment: UsersFragment)
}
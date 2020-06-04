package com.nefrit.users.presentation.details.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.di.scope.ScreenScope
import com.nefrit.users.presentation.details.UserActivity
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
            @BindsInstance activity: AppCompatActivity,
            @BindsInstance userId: Int
        ): UserComponent
    }

    fun inject(activity: UserActivity)
}
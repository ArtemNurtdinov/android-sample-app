package com.nefrit.users.presentation.list.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.core_di.scope.FeatureScope
import com.nefrit.users.presentation.list.UsersActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UsersModule::class
    ]
)
@FeatureScope
interface UsersComponent {

    @Subcomponent.Factory
    interface Builder {

        fun create(
            @BindsInstance activity: AppCompatActivity
        ): UsersComponent
    }

    fun inject(activity: UsersActivity)
}
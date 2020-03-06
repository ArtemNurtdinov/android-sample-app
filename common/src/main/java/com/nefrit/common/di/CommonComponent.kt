package com.nefrit.common.di

import android.content.Context
import com.nefrit.core_di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        CommonModule::class
    ]
)
@ApplicationScope
abstract class CommonComponent : CommonApi {

    @Component.Builder
    interface Builder {

        fun build(): CommonComponent

        @BindsInstance
        fun context(context: Context): Builder
    }
}
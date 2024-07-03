package com.nefrit.app.di.app

import com.nefrit.app.App
import com.nefrit.app.di.main.MainDependencies
import com.nefrit.common.data.db.di.DbModule
import com.nefrit.common.di.modules.CommonModule
import com.nefrit.common.di.modules.NetworkModule
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.settings.di.SettingsDependencies
import com.nefrit.users.di.UserFeatureDependencies
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        DbModule::class,
        NetworkModule::class,
        NavigationModule::class
    ]
)
interface AppComponent : MainDependencies, UserFeatureDependencies, SettingsDependencies {

    companion object {

        fun init(application: App): AppComponent {
            return DaggerAppComponent
                .builder()
                .application(application)
                .build()
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
package com.nefrit.app.di.app

import com.nefrit.app.navigation.Navigator
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.settings.presentation.SettingsRouter
import com.nefrit.users.presentation.UsersRouter
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideMainRouter(navigator: Navigator): UsersRouter = navigator

    @ApplicationScope
    @Provides
    fun provideSettingsRouter(navigator: Navigator): SettingsRouter = navigator
}
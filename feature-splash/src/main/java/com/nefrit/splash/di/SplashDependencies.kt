package com.nefrit.splash.di

import com.nefrit.core.di.ComponentDependencies
import com.nefrit.splash.domain.SplashRouter

interface SplashDependencies : ComponentDependencies {

    fun provideSplashRouter(): SplashRouter
}
package com.nefrit.splash.di

import com.nefrit.core.interfaces.ComponentDependencies
import com.nefrit.splash.SplashRouter

interface SplashDependencies : ComponentDependencies {

    fun provideSplashRouter(): SplashRouter
}
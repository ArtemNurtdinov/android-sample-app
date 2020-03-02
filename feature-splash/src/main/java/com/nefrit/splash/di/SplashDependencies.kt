package com.nefrit.splash.di

import com.nefrit.splash.domain.SplashRouter

interface SplashDependencies : jp.co.soramitsu.core_di.ComponentDependencies {

    fun provideSplashRouter(): SplashRouter
}
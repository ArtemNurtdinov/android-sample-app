package com.nefrit.main.di

import com.nefrit.core.interfaces.ComponentDependencies
import com.nefrit.main.MainRouter

interface MainDependencies : ComponentDependencies {

    fun provideRouter(): MainRouter
}
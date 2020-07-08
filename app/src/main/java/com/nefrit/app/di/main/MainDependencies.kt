package com.nefrit.app.di.main

import com.nefrit.app.di.deps.ComponentDependencies
import com.nefrit.app.navigation.Navigator

interface MainDependencies: ComponentDependencies {

    fun navigator(): Navigator
}
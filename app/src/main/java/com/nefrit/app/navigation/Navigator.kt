package com.nefrit.app.navigation

import android.content.Context
import androidx.navigation.NavController
import com.nefrit.splash.SplashRouter
import com.nefrit.users.UsersRouter
import com.nefrit.users.presentation.details.UserActivity
import com.nefrit.users.presentation.list.UsersActivity

class Navigator : UsersRouter, SplashRouter {

    private var navController: NavController? = null

    fun attachNavController(navController: NavController, graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

    fun detachNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    override fun openUser(context: Context, userId: Int) {
        UserActivity.start(context, userId)
    }

    override fun openUsers(context: Context) {
        UsersActivity.start(context)
    }
}
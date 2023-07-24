package com.nefrit.app.navigation

import androidx.navigation.NavController
import com.nefrit.app.R
import com.nefrit.users.UsersRouter
import com.nefrit.users.presentation.details.UserFragment

class Navigator : UsersRouter {

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

    override fun openUser(userId: Int) {
        navController?.navigate(R.id.userFragment, UserFragment.createBundle(userId))
    }

    override fun returnToUsers() {
        navController?.popBackStack()
    }
}
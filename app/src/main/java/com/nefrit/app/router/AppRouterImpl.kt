package com.nefrit.app.router

import android.content.Context
import com.nefrit.user.presentation.UserActivity
import com.nefrit.users.presentation.UsersActivity
import javax.inject.Inject

class AppRouterImpl @Inject constructor() : AppRouter {

    override fun openUsers(context: Context) {
        UsersActivity.start(context)
    }

    override fun openUser(context: Context, userId: Int) {
        UserActivity.start(context, userId)
    }
}
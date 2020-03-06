package com.nefrit.users

import android.content.Context

interface UsersRouter {

    fun openUser(context: Context, userId: Int)
}
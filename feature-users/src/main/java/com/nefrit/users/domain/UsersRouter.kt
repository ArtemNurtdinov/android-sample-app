package com.nefrit.users.domain

import android.content.Context

interface UsersRouter {

    fun openUser(context: Context, userId: Int)
}
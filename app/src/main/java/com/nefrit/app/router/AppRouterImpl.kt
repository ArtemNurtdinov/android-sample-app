package com.nefrit.app.router

import android.content.Context
import com.nefrit.main.MainActivity
import com.nefrit.second.SecondActivity
import javax.inject.Inject

class AppRouterImpl @Inject constructor() : AppRouter {

    override fun moveToSecond(context: Context) {
        SecondActivity.start(context)
    }

    override fun openMain(context: Context) {
        MainActivity.start(context)
    }
}
package com.nefrit.main

import android.content.Context
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val interactor: MainInteractor,
    private val router: MainRouter
) : ViewModel() {

    fun openSecond(context: Context) {
        router.moveToSecond(context)
    }
}
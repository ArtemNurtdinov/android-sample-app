package com.nefrit.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.nefrit.core.interactors.MainInteractor
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val interactor: MainInteractor,
    private val router: MainRouter
) : ViewModel() {

    fun openSecond(context: Context) {
        router.moveToSecond(context)
    }
}
package com.nefrit.splash

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nefrit.common.utils.Event

class SplashViewModel(
    private val router: SplashRouter
) : ViewModel() {

    val openScannerEvent = MutableLiveData<Event<Unit>>()

    init {
        openScannerEvent.value = Event(Unit)
    }

    fun openScanner(context: Context) {
        router.openMain(context)
    }
}
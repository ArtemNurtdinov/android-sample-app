package com.nefrit.splash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.EventObserver
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.splash.di.SplashComponent
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SplashComponent
            .init(this, findComponentDependencies())
            .inject(this)

        splashViewModel.openScannerEvent.observe(this, EventObserver {
            splashViewModel.openScanner(this)
            finish()
        })
    }
}
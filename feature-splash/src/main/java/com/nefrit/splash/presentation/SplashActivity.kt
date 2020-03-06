package com.nefrit.splash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.EventObserver
import com.nefrit.core_di.FeatureUtils
import com.nefrit.splash.di.SplashFeatureApi
import com.nefrit.splash.di.SplashFeatureComponent
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FeatureUtils.getFeature<SplashFeatureComponent>(this, SplashFeatureApi::class.java)
            .splashComponentFactory()
            .create(this)
            .inject(this)

        splashViewModel.openUsersEvent.observe(this, EventObserver {
            splashViewModel.openScanner(this)
            finish()
        })
    }
}
package com.nefrit.common.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nefrit.common.R
import com.nefrit.common.utils.setBarColorBackground
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    @Inject protected open lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(rootView())
        setBarColorBackground(R.color.colorPrimaryDark)
        inject()
        initViews()
        subscribe(viewModel)
    }

    abstract fun inject()

    abstract fun rootView(): View

    abstract fun initViews()

    abstract fun subscribe(viewModel: T)
}
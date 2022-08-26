package com.nefrit.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.setBarColorBackground
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    @Inject protected open lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
        setBarColorBackground(android.R.color.black)
        inject()
        initViews()
        subscribe(viewModel)
    }

    abstract fun inject()

    abstract fun layoutResource(): Int

    abstract fun initViews()

    abstract fun subscribe(viewModel: T)
}
package com.nefrit.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        inject()
        setupViews()
        subscribe()
    }

    protected abstract fun inject()

    protected abstract fun setupViews()

    protected open fun subscribe() {}
}
package com.nefrit.second

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.base.BaseActivity
import com.nefrit.common.utils.viewModelProvider
import com.nefrit.second.di.SecondComponent
import javax.inject.Inject

class SecondActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_second

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var secondViewModel: SecondViewModel

    override fun inject() {
        SecondComponent.init(this).inject(this)
        secondViewModel = viewModelProvider(viewModelFactory)
    }

    override fun setupViews() {
    }
}
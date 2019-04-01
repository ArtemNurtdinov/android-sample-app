package com.nefrit.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.base.BaseActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.common.utils.viewModelProvider
import com.nefrit.main.di.DaggerMainComponent
import com.nefrit.main.di.MainComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    override fun inject() {
        MainComponent.init(this).inject(this)

        mainViewModel = viewModelProvider(viewModelFactory)
    }

    override fun setupViews() {
        clickMeBtn.setOnClickListener { mainViewModel.openSecond(this) }
    }
}
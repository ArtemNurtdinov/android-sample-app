package com.nefrit.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.main.di.DaggerMainComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent
            .builder()
            .withActivity(this)
            .withDependencies(findComponentDependencies())
            .build()
            .inject(this)

        clickMeBtn.setOnClickListener { mainViewModel.openSecond(this) }
    }
}
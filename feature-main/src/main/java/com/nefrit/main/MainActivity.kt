package com.nefrit.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.main.di.DaggerMainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

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

        Log.d("mylog", "test")
    }
}
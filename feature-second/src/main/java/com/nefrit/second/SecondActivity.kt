package com.nefrit.second

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.second.di.DaggerSecondComponent
import javax.inject.Inject

class SecondActivity: AppCompatActivity() {

    @Inject lateinit var mainViewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        DaggerSecondComponent
            .builder()
            .withActivity(this)
            .withDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }
}
package com.nefrit.second

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.second.di.DaggerSecondComponent
import javax.inject.Inject

class SecondActivity: AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }

    @Inject lateinit var secondViewModel: SecondViewModel

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
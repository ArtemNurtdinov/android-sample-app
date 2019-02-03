package com.nefrit.splash.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.splash.SplashRouter
import com.nefrit.splash.SplashViewModel
import javax.inject.Inject

class SplashViewModelFactory @Inject constructor(
    private val router: SplashRouter
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SplashViewModel(router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
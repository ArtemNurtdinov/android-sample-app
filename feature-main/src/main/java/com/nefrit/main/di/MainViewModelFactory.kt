package com.nefrit.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.main.MainInteractor
import com.nefrit.main.MainRouter
import com.nefrit.main.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val interactor: MainInteractor,
    private val router: MainRouter
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(interactor, router) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.nefrit.second.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.second.SecondViewModel
import javax.inject.Inject

class SecondViewModelFactory @Inject constructor(

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SecondViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
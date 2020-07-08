package com.nefrit.common.di

import android.content.Context
import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.resources.ResourceManager

interface CommonApi {

    fun context(): Context

    fun provideResourceManager(): ResourceManager

    fun provideNetworkApiCreator(): NetworkApiCreator
}
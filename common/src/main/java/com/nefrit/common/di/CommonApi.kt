package com.nefrit.common.di

import android.content.Context
import com.nefrit.common.core.config.AppProperties
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.data.network.NetworkApiCreator

interface CommonApi {

    fun context(): Context

    fun provideResourceManager(): ResourceManager

    fun provideNetworkApiCreator(): NetworkApiCreator

    fun provideAppProperties(): AppProperties
}
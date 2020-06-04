package com.nefrit.network.di

import com.nefrit.network.NetworkApiCreator

interface NetworkApi {

    fun provideNetworkApiCreator(): NetworkApiCreator
}
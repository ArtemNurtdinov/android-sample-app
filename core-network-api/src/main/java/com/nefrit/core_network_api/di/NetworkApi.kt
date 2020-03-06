package com.nefrit.core_network_api.di

import com.nefrit.core_network_api.NetworkApiCreator

interface NetworkApi {

    fun provideNetworkApiCreator(): NetworkApiCreator
}
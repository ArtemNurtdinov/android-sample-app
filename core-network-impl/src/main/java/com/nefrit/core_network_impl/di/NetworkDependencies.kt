package com.nefrit.core_network_impl.di

import com.nefrit.common.resources.ResourceManager

interface NetworkDependencies {

    fun resourceManager(): ResourceManager
}
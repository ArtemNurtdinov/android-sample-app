package com.nefrit.common.di

interface FeatureContainer {

    fun <T> getFeature(key: Class<*>): T

    fun releaseFeature(key: Class<*>)
}
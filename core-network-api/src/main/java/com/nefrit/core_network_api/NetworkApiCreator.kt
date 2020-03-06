package com.nefrit.core_network_api

interface NetworkApiCreator {

    fun <T> create(service: Class<T>): T
}
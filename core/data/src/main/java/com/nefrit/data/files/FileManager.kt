package com.nefrit.data.files

import java.io.File

interface FileManager {

    fun createFile(filename: String): File

    fun createFile(filename: String, content: ByteArray): File

    fun getFile(filename: String): File

    fun getRawFile(filename: String): ByteArray

    fun getRawFile(file: File): ByteArray

    fun deleteFile(filename: String)

    fun deleteFile(file: File)

    fun append(filename: String, content: ByteArray)

    fun append(file: File, content: ByteArray)
}
package com.nefrit.data.files

import android.content.Context
import com.nefrit.common.di.ApplicationScope
import java.io.File
import javax.inject.Inject

class FileManagerImpl @Inject constructor(
    @ApplicationScope private val context: Context,
) : FileManager {

    override fun createFile(filename: String): File {
        return File(context.filesDir, filename).apply {
            createNewFile()
        }
    }

    override fun createFile(filename: String, content: ByteArray): File {
        return File(context.filesDir, filename).apply {
            createNewFile()
            writeBytes(content)
        }
    }

    override fun getFile(filename: String) = File(context.filesDir, filename)

    override fun getRawFile(filename: String): ByteArray {
        return File(context.filesDir, filename).readBytes()
    }

    override fun getRawFile(file: File): ByteArray {
        return file.readBytes()
    }

    override fun deleteFile(filename: String) {
        File(context.filesDir, filename).apply {
            delete()
        }
    }

    override fun deleteFile(file: File) {
        file.delete()
    }

    override fun append(filename: String, content: ByteArray) {
        File(context.filesDir, filename).apply {
            val currentContent = readBytes()
            writeBytes(currentContent.plus(content))
        }
    }

    override fun append(file: File, content: ByteArray) {
        val currentContent = file.readBytes()
        file.writeBytes(currentContent.plus(content))
    }
}
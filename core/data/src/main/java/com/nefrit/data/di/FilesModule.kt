package com.nefrit.data.di

import com.nefrit.common.di.ApplicationScope
import com.nefrit.data.files.FileManager
import com.nefrit.data.files.FileManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FilesModule {

    @Binds
    @ApplicationScope
    fun fileManager(fileManagerImpl: FileManagerImpl): FileManager
}
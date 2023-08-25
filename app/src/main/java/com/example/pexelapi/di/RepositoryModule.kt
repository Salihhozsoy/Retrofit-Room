package com.example.pexelapi.di

import com.example.pexelapi.data.repository.LocalPhotosRepository
import com.example.pexelapi.data.repository.LocalPhotosRepositoryImpl
import com.example.pexelapi.data.repository.PhotoRepository
import com.example.pexelapi.data.repository.PhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providePhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository = photoRepositoryImpl

    @Provides
    fun provideLocalPhotosRepository(localPhotosRepositoryImpl: LocalPhotosRepositoryImpl):LocalPhotosRepository =localPhotosRepositoryImpl
}
package com.example.pexelapi.data.repository

import com.example.pexelapi.data.local.PhotoDao
import com.example.pexelapi.data.local.PhotoEntity
import javax.inject.Inject

class LocalPhotosRepositoryImpl @Inject constructor(private val photoDao: PhotoDao):LocalPhotosRepository {

    override suspend fun insert(photoEntity: PhotoEntity) {
        photoDao.addPhoto(photoEntity)
    }

    override suspend fun getPhotosFromDb(): List<PhotoEntity> {
        return photoDao.getPhotosFromDb()
    }
}
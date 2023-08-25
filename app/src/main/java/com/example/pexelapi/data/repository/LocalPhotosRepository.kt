package com.example.pexelapi.data.repository

import com.example.pexelapi.data.local.PhotoEntity

interface LocalPhotosRepository {
    suspend fun insert(photoEntity: PhotoEntity)
    suspend fun getPhotosFromDb(): List<PhotoEntity>
}
package com.example.pexelapi.data.repository

import com.example.pexelapi.data.api.model.Photo
import com.example.pexelapi.data.api.service.PhotoService
import com.example.pexelapi.data.local.PhotoDao
import com.example.pexelapi.data.local.PhotoEntity
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(private val photoService: PhotoService , private  val photoDao: PhotoDao) : PhotoRepository {

    override suspend fun getAllPhotos(query:String):List<Photo> {
      val photos= photoService.getAllPhotos(query).photos
        savePhotosToDb(photos)
        return photos
    }
    override suspend fun savePhotosToDb(photos: List<Photo>) {
        val photoEntities =photos.map { PhotoEntity(photoUrl = it.url , photographer = it.photographer) }
        photoDao.addPhoto(photoEntities)
    }
}
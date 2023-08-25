package com.example.pexelapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Insert
    suspend fun addPhoto(photoEntity: PhotoEntity)

    @Query("select * from PhotoEntity")
    suspend fun getPhotosFromDb() :List<PhotoEntity>
}
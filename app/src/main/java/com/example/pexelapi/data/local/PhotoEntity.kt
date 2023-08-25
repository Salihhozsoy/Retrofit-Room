package com.example.pexelapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val photoUrl:String,
    val photographer:String
)
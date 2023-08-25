package com.example.pexelapi.data.api.model

import com.example.pexelapi.data.local.PhotoEntity

data class Photo(
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val src: Src,
    val url: String,
    val width: Int,
    var isSelected:Boolean =false
)

fun Photo.toPhotoEntity(): PhotoEntity{
    return PhotoEntity(photoUrl = this.url, photographer = this.photographer)
}
package com.example.pexelapi.data.state


import com.example.pexelapi.data.local.PhotoEntity

sealed class LocalListState{
    object Idle:LocalListState()
    object Loading:LocalListState()
    object Empty:LocalListState()
    class Result(val localPhotos:List<PhotoEntity>):LocalListState()
    class Error(val throwable: Throwable):LocalListState()
}

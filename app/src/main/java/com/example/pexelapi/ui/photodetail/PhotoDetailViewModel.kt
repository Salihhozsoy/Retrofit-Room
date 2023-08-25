package com.example.pexelapi.ui.photodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelapi.data.repository.LocalPhotosRepository
import com.example.pexelapi.data.state.LocalListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(private val localPhotosRepository: LocalPhotosRepository):ViewModel() {

    private val _localListState:MutableStateFlow<LocalListState> = MutableStateFlow(LocalListState.Idle)
    val localListState:StateFlow<LocalListState> =_localListState

    fun getPhotosLocal(){
        viewModelScope.launch {
            kotlin.runCatching {
                _localListState.value=LocalListState.Loading
                val localPhotos= localPhotosRepository.getPhotosFromDb()
                if(localPhotos.isEmpty()) _localListState.value=LocalListState.Empty
                else _localListState.value =LocalListState.Result(localPhotos)
            }.onFailure {
                _localListState.value=LocalListState.Error(it)
            }
        }
    }
}
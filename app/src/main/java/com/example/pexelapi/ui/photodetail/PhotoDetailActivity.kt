package com.example.pexelapi.ui.photodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pexelapi.R
import com.example.pexelapi.data.state.LocalListState
import com.example.pexelapi.databinding.ActivityPhotoDetailBinding
import com.example.pexelapi.ui.adapter.LocalPhotoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhotoDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPhotoDetailBinding
    private val viewModel:PhotoDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhotoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getPhotosLocal()
        observeLocalListState()
    }

    private fun observeLocalListState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.localListState.collect{
                    when(it){
                        LocalListState.Idle->{}
                        LocalListState.Empty->{}
                        LocalListState.Loading->{}
                        is LocalListState.Result->{
                            binding.rvPhotosFromLocal.adapter = LocalPhotoAdapter(this@PhotoDetailActivity,it.localPhotos)
                        }
                        is LocalListState.Error->{}
                    }
                }
            }
        }
    }
}
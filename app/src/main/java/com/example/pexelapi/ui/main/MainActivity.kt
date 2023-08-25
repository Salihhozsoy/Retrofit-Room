package com.example.pexelapi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pexelapi.data.api.model.Photo
import com.example.pexelapi.data.state.PhotoListState
import com.example.pexelapi.databinding.ActivityMainBinding
import com.example.pexelapi.ui.adapter.PhotoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observePhotoListState()
        viewModel.getAllPhotos("animal")
    }

    private fun observePhotoListState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.photoListState.collect {
                    when (it) {
                        PhotoListState.Idle -> {}
                        PhotoListState.Loading -> {}
                        PhotoListState.Empty -> {}
                        is PhotoListState.Result -> {
                            adapter = PhotoAdapter(this@MainActivity, it.photos, this@MainActivity::onClick)
                            binding.rvPhotos.adapter = adapter
                        }
                        is PhotoListState.Error -> {}
                    }
                }
            }
        }
    }

    private fun onClick(photo: Photo) {}
}
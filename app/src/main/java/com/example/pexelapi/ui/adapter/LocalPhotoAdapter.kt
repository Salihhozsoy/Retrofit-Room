package com.example.pexelapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pexelapi.data.local.PhotoEntity
import com.example.pexelapi.databinding.InfoListItemBinding

class LocalPhotoAdapter(private val context: Context, private val locals: List<PhotoEntity>) :
    RecyclerView.Adapter<LocalPhotoAdapter.CustomViewHolder>() {

    class CustomViewHolder(binding: InfoListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val photoUrl = binding.photoUrl
        val photographer = binding.photographer
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocalPhotoAdapter.CustomViewHolder {
        val binding = InfoListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocalPhotoAdapter.CustomViewHolder, position: Int) {
        val locals=locals[position]

        holder.photoUrl.text = locals.photoUrl
        holder.photographer.text=locals.photographer
    }

    override fun getItemCount(): Int {
        return locals.size
    }
}
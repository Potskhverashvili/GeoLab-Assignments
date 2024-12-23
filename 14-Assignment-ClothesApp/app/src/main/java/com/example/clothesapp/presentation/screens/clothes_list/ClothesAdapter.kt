package com.example.clothesapp.presentation.screens.clothes_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothesapp.data.ClothesImage
import com.example.clothesapp.databinding.ItemClothBinding

class ClothesAdapter :
    ListAdapter<ClothesImage, ClothesAdapter.ClothesViewHolder>(ClothesItemCallBack()) {

    // ----------------------------- View Holder ---------------------------
    inner class ClothesViewHolder(private val binding: ItemClothBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clothes: ClothesImage) = with(binding) {
            Glide.with(root)
                .load(clothes.imgId)
                .into(clotheImageView)
        }
    }

    // ------------------------------- DiffUtil CallBack ---------------------
    class ClothesItemCallBack : DiffUtil.ItemCallback<ClothesImage>() {
        override fun areItemsTheSame(
            oldItem: ClothesImage,
            newItem: ClothesImage,
        ) = oldItem.imgId == newItem.imgId

        override fun areContentsTheSame(
            oldItem: ClothesImage,
            newItem: ClothesImage,
        ) = oldItem == newItem

    }


    // ------------------------------- Override Methods -----------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        return ClothesViewHolder(
            ItemClothBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
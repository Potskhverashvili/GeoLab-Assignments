package com.example.network.presentation

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.network.data.model.MarioData

import com.example.network.databinding.ItemMarioBinding

class MarioAdapter : RecyclerView.Adapter<MarioAdapter.MarioViewHolder>() {
    // ---------------------------- Properties ----------------------------
    private var amiiboList = listOf<MarioData.Amiibo>()

    // ---------------------------- update Amiibo List ----------------------------
    fun updateAmiiboList(newList: List<MarioData.Amiibo>) {
        amiiboList = newList
        notifyDataSetChanged()
       // TODO Add DiffUtils
    }

    // ---------------------------- Override Methods ----------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarioViewHolder {
        return MarioViewHolder(
            ItemMarioBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarioViewHolder, position: Int) {
        holder.bind(amiiboList[position])
    }

    override fun getItemCount() = amiiboList.size

    // --------------------------- View Holder ---------------------------
    inner class MarioViewHolder(private val binding: ItemMarioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(amiibo: MarioData.Amiibo) = with(binding) {
            marioNameTextView.text = amiibo.name
            Glide.with(root)
                .load(amiibo.image)
                .into(marioImageView)
        }
    }
}

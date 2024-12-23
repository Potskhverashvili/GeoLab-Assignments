package com.example.clothesapp.presentation.screens.clothes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clothesapp.R
import com.example.clothesapp.data.ClothesImage
import com.example.clothesapp.databinding.FragmentClothesListBinding

class ClothesListFragment : Fragment() {
    // Properties
    private lateinit var binding: FragmentClothesListBinding
    private val adapter = ClothesAdapter()
    private val imageIds = listOf(
        ClothesImage(R.drawable.img_cloth1),
        ClothesImage(R.drawable.img_cloth2),
        ClothesImage(R.drawable.img_cloth3),
        ClothesImage(R.drawable.img_cloth4),
        ClothesImage(R.drawable.img_cloth5)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentClothesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setImages()
    }


    // ---------- Helper Methods -----------
    private fun initViews() {
        binding.clothesListRecyclerView.adapter = adapter
    }

    private fun setImages() {
        adapter.submitList(imageIds)
    }
}
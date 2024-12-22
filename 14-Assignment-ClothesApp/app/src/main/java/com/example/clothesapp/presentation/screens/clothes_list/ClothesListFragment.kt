package com.example.clothesapp.presentation.screens.clothes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clothesapp.databinding.FragmentClothesListBinding

class ClothesListFragment : Fragment() {
    private lateinit var binding: FragmentClothesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentClothesListBinding.inflate(inflater, container, false)
        return binding.root
    }
}
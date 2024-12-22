package com.example.clothesappui.presentation.screens.clothes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clothesappui.databinding.FragmentClothesListBinding

class ClothesListFragment : Fragment() {

    private lateinit var bindig: FragmentClothesListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindig = FragmentClothesListBinding.inflate(inflater,container, false)
        return bindig.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
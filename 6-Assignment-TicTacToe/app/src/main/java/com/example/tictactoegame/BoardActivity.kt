package com.example.tictactoegame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoegame.databinding.ActivityBoardBinding

class BoardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityBoardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            binding.button1.text = "X"
        }
    }
}

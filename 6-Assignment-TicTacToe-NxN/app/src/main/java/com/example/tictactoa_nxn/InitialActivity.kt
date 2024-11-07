package com.example.tictactoa_nxn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoa_nxn.databinding.ActivityInitialBinding

class InitialActivity : AppCompatActivity() {

    private val binding by lazy { ActivityInitialBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val gridSize = binding.enterGridSize.toString()

        binding.continueButton.setOnClickListener {
            val gridActivity = Intent(this, GridActivity::class.java)
            gridActivity.putExtra("gridSize", gridSize.toInt())
            startActivity(gridActivity)
        }
    }
}

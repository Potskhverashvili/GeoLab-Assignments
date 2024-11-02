package com.example.minishop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minishop.databinding.ActivityOrderProductBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderProductBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var count = 0

        binding.orderButton.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }
        binding.plusButton.setOnClickListener {
            count++
            binding.productAmount.text = count.toString()
        }

        binding.minusButton.setOnClickListener {
            count--
            binding.productAmount.text = count.toString()
        }

        binding.backButton.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }
    }
}

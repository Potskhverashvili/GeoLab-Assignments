package com.example.minishop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minishop.databinding.ActivityOrderProductBinding

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding: ActivityOrderProductBinding
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val productAmount = binding.productAmount
        var count = 0

        binding.orderButton.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }

        binding.plusButton.setOnClickListener {
            count++
            productAmount.text = count.toString()
        }

        binding.minusButton.setOnClickListener {
            count--
            productAmount.text = count.toString()
        }

        binding.backButton.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }
    }
}

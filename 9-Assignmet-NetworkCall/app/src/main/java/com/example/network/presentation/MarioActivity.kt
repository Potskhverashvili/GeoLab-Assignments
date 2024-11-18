package com.example.network.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.network.data.RetrofitInstance
import com.example.network.databinding.ActivityMarioBinding
import kotlinx.coroutines.launch

class MarioActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMarioBinding.inflate(layoutInflater) }
    private val marioAdapter = MarioAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        getDataFromNetwork()
    }

    private fun initRecyclerView() {
        binding.marioRecyclerView.adapter = marioAdapter
    }

    private fun getDataFromNetwork() {
        lifecycleScope.launch {
            val mario = RetrofitInstance.getMarioApi().getMarioData()
            marioAdapter.updateAmiiboList(mario.body()?.amiibo ?: emptyList())

        }
    }
}

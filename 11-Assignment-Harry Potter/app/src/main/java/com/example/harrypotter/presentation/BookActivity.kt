package com.example.harrypotter.presentation

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.harrypotter.R
import com.example.harrypotter.data.repository.BookRepository
import kotlinx.coroutines.launch

class BookActivity : AppCompatActivity() {


    private val bookRepository = BookRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


        lifecycleScope.launch {
            d("MyLog", bookRepository.getBooksList().toString())
        }


    }
}
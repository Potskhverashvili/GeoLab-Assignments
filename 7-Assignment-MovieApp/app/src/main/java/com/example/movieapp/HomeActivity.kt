package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val movies = listOf(
        Movie("Apocalypse Now", 6.3, R.drawable.img_apocalypse),
        Movie("Capitan America", 7.5, R.drawable.img_capitan_america),
        Movie("F1", 7.8, R.drawable.img_f1),
        Movie("Interstellar", 8.6, R.drawable.img_interstellar),
        Movie("Mr. Robot", 8.2, R.drawable.img_mr_robot),
        Movie("Who Am I", 8.1, R.drawable.img_who_am_i),

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.movieRecyclerView.adapter = MovieAdapter(movies)

    }
}

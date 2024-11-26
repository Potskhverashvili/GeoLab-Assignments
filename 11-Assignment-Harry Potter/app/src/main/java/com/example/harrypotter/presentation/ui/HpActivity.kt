package com.example.harrypotter.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.harrypotter.R
import com.example.harrypotter.databinding.ActivityBookBinding

class HpActivity : AppCompatActivity() {
    private val binding by lazy { ActivityBookBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        toggleBottomButtons()
    }

    private fun toggleBottomButtons() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navBooksButton -> {
                    navController.navigate(R.id.bookListFragment)
                    true
                }

                R.id.navMoviesButton -> {
                    navController.navigate(R.id.moviesFragment)
                    true
                }

                else -> false
            }
        }
    }
}
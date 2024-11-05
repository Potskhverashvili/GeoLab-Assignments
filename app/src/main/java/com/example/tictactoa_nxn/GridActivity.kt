package com.example.tictactoa_nxn

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoa_nxn.databinding.ActivityGridBinding


class GridActivity : AppCompatActivity() {


    private val binding by lazy { ActivityGridBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // Assuming you have a reference to the GridLayout:
        val gridLayout = binding.gridLayout
        val N = 3// Adjust N to the desired grid size

        gridLayout.columnCount = N
        gridLayout.rowCount = N

        for (i in 0 until N) {
            for (j in 0 until N) {
                val button = Button(this)
               // button.text = "Button" + (i * N + j) // Set button text
                button.setBackgroundResource(R.drawable.shape_grid_buttons)
                button.id = (i * N + j)
                button.layoutParams = GridLayout.LayoutParams()
                gridLayout.addView(button)

            }
        }
    }
}
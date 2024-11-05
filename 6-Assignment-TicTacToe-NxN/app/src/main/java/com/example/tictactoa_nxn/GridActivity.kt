package com.example.tictactoa_nxn

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoa_nxn.databinding.ActivityGridBinding


class GridActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGridBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fillGrid(gridSize)
        setListener()
    }

    // -------------------------------------- Attributes -----------------------------------------
    private val gridSize = 3

    private var currentSymbol = "X"
    private var clickCounter = 0
    private val buttonsList = mutableListOf<Button>()
    private val boardState = Array<String>(gridSize * gridSize) { "" }

    // ----------------------------------- Helper Functions ---------------------------------------
    // ------------ Fill Grid ------------
    private fun fillGrid(gridSize: Int) {

        val gridLayout = binding.gridLayout // Assuming you have a reference to the GridLayout:
        gridLayout.columnCount = gridSize
        gridLayout.rowCount = gridSize

        for (rowIndex in 0 until gridSize) {
            for (columnIndex in 0 until gridSize) {

                val button = Button(this)
                button.setBackgroundResource(R.drawable.shape_grid_buttons)
                button.id = (rowIndex * gridSize + columnIndex)

                buttonsList.add(button) //Save Buttons in the list
                // button.layoutParams = GridLayout.LayoutParams()
                gridLayout.addView(button)
            }
        }
    }

    // --- dynamically define winning combinations ---
    private fun defineWiningCombination(gridSize: Int) {

        val winingCombinations = mutableListOf<IntArray>()

        // Row
        for (i in 0 until gridSize) {
            val row = IntArray(gridSize)
            for (j in 0 until gridSize) {
                row[j] = i * gridSize + j
            }
            winingCombinations.add(row)
        }

    }

    // --- Sets up click listeners for all buttons ---
    private fun setListener() {
        buttonsList.forEach { button ->
            button.setOnClickListener {
                click(button)
            }
        }

    }

    // ---- Click method For grid Buttons ----
    private fun click(button: Button) {
        //Checks if the button's text is empty and sets current symbol
        if (button.text.isEmpty()) {
            button.text = currentSymbol


            boardState[button.id] = currentSymbol
            println(boardState[button.id])

            /*  // ------------- Get Button "Id" --------------------
              val buttonId = getButtonId(button)
              boardState[buttonId] = currentSymbol

              // -------------- Check Winner ----------------------
              if (checkWinner()) {
                  Toast.makeText(this@BoardActivity, "$currentSymbol Won!", Toast.LENGTH_SHORT).show()
              } else if (clickCounter == 9) {
                  Toast.makeText(this@BoardActivity, "No Winner!", Toast.LENGTH_SHORT).show()
              }*/

            // ----------- Toggle Current Symbol -----------------
            currentSymbol = if (currentSymbol == "X") "O" else "X"
        }
    }
}


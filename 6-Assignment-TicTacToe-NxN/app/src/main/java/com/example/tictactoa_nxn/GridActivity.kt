package com.example.tictactoa_nxn

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoa_nxn.databinding.ActivityGridBinding


class GridActivity : AppCompatActivity() {

    private val binding by lazy { ActivityGridBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fillGrid()
        defineWiningCombinations()
        setListener()
    }

    // -------------------------------------- Attributes -----------------------------------------

    private var gridSize = 4

    private var currentSymbol = "X"
    private var clickCounter = 0
    private val buttonsList = mutableListOf<Button>()
    private val winningCombinations = mutableListOf<IntArray>()
    private val boardState = Array<String>(gridSize * gridSize) { "" }


    // ----------------------------------- Helper Functions ---------------------------------------

    // ------------ Fill Grid ------------
    private fun fillGrid() {
        val gridLayout = binding.gridLayout // reference to the GridLayout:
        gridLayout.columnCount = gridSize
        gridLayout.rowCount = gridSize

        // Define buttons
        for (rowIndex in 0 until gridSize) {
            for (columnIndex in 0 until gridSize) {
                val button = Button(this)
                button.setBackgroundResource(R.drawable.shape_grid_buttons)
                button.id = (rowIndex * gridSize + columnIndex)

                buttonsList.add(button) //Save Buttons in the list
                button.layoutParams = GridLayout.LayoutParams()

                gridLayout.addView(button)
            }
        }
    }

    // --- dynamically define winning combinations ---
    private fun defineWiningCombinations() {
        // Row
        for (i in 0 until gridSize) {
            val row = IntArray(gridSize)
            for (j in 0 until gridSize) {
                row[j] = i * gridSize + j
            }
            winningCombinations.add(row)
        }

        // Column
        for (j in 0 until gridSize) {
            val column = IntArray(gridSize)
            for (i in 0 until gridSize) {
                column[i] = i * gridSize + j
            }
            winningCombinations.add(column)
        }

        // Diagonals
        val diagonal1 = IntArray(gridSize)
        val diagonal2 = IntArray(gridSize)

        for (i in 0 until gridSize) {
            diagonal1[i] = i * gridSize + i
            diagonal2[i] = i * gridSize + (gridSize - i - 1)
        }
        winningCombinations.add(diagonal1)
        winningCombinations.add(diagonal2)
    }


    // --- Sets up click listeners for all buttons ---
    private fun setListener() {

        // Reset Button
        binding.restartButton.setOnClickListener {
            resetGame()
        }

        buttonsList.forEach { button ->
            button.setOnClickListener {
                click(button)
            }
        }
    }

    // ---- Click method For grid Buttons ----
    private fun click(button: Button) {
        //Checks if the button's text is empty and sets current symbol
        if (button.text.isEmpty() && !checkWinner()) {
            button.text = currentSymbol

            boardState[button.id] = currentSymbol
            clickCounter++

            if (checkWinner()) {
                Toast.makeText(this@GridActivity, "$currentSymbol Won!", Toast.LENGTH_SHORT).show()

            } else if (clickCounter == gridSize * gridSize) {
                Toast.makeText(this@GridActivity, "No Winner!", Toast.LENGTH_SHORT).show()
            }

            // ----------- Toggle Current Symbol -----------------
            currentSymbol = if (currentSymbol == "X") "O" else "X"
        }
    }


    // ---------------- Check Winner Method -----------------------
    private fun checkWinner(): Boolean {
        for (combination in winningCombinations) {
            val symbol = boardState[combination[0]]
            var count = 0
            for (element in combination) {
                if (boardState[element].isNotEmpty() && boardState[element] == symbol) {
                    count++
                }
            }
            if (count == gridSize) {
                return true
            }
        }
        return false
    }


    // Reset Game Method
    private fun resetGame() {
        clickCounter = 0
        currentSymbol = "X"
        boardState.fill("")
        buttonsList.forEach { button ->
            button.text = ""
        }
    }

}



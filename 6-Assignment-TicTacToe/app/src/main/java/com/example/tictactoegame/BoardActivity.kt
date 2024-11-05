package com.example.tictactoegame

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoegame.databinding.ActivityBoardBinding

class BoardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityBoardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListener()
    }

    // ------------------------------- Attributes --------------------------
    private var currentSymbol = "X"
    private var clickCounter = 0
    private val boardState = arrayOf("", "", "", "", "", "", "", "", "")

    private var winningCombinations: Array<IntArray> = arrayOf(
        // Row
        intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8),
        // Column
        intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8),
        // Diagonal
        intArrayOf(0, 4, 8), intArrayOf(2, 4, 6)
    )

    // ----------------------------------- Helper Functions ---------------------------------------
    // Sets up click listeners for all buttons
    private fun setListener() {

        // Reset Button
        binding.restartButton.setOnClickListener {
            resetGame()
        }

        // Grid Buttons
        with(binding) {
            listOf(
                button0,
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8
            ).forEach { button ->
                button.setOnClickListener {
                    click(button)
                }
            }
        }
    }

    // Click method For grid Buttons
    private fun click(button: Button) {
        //Checks if the button's text is empty and sets current symbol
        if (button.text.isEmpty()) {
            button.text = currentSymbol

            // Count game move
            clickCounter++

            // ------------- Get Button "Id" --------------------
            val buttonId = getButtonId(button)
            boardState[buttonId] = currentSymbol

            // -------------- Check Winner ----------------------
            if (checkWinner()) {
                Toast.makeText(this@BoardActivity, "$currentSymbol Won!", Toast.LENGTH_SHORT).show()
            } else if (clickCounter == 9) {
                Toast.makeText(this@BoardActivity, "No Winner!", Toast.LENGTH_SHORT).show()
            }
            // ----------- Toggle Current Symbol -----------------
            currentSymbol = if (currentSymbol == "X") "O" else "X"
        }
    }

    // Get Button Id Method
    private fun getButtonId(button: Button): Int {
        val buttonId = button.resources.getResourceEntryName(button.id)
        return buttonId.last().digitToInt()
    }

    // Check Winner Method
    private fun checkWinner(): Boolean {
        for (winingPosition in winningCombinations) {
            if (
                boardState[winingPosition[0]].isNotEmpty()
                && boardState[winingPosition[0]] == boardState[winingPosition[1]]
                && boardState[winingPosition[1]] == boardState[winingPosition[2]]
            ) {
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
        with(binding) {
            listOf(
                button0,
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8
            ).forEach { button ->
                button.text = ""
            }
        }
    }
}

package com.example.tictactoegame

import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoegame.databinding.ActivityBoardBinding

class BoardActivity : AppCompatActivity() {


    private val binding by lazy { ActivityBoardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("MyLog", "onCreate")

        setContentView(binding.root)
        setListener()

    }


    // ------------------------------- Attributes --------------------------
    private var currentSymbol = "X"

    // ---------------------Indexes 0  1  2  3  4  5  6  7  8
    private val gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

    private var winningPositions: Array<IntArray> = arrayOf(
        // Row
        intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8),
        // Column
        intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8),
        // Diagonal
        intArrayOf(0, 4, 8), intArrayOf(2, 4, 6)
    )


    // ----------------------------------- Helper Functions ---------------------------------------

    // Check Winner
    private fun checkWinner(): Boolean {
        for (wingPosition in winningPositions) {
            if (
                gameState[wingPosition[0]] != 2
                && gameState[wingPosition[0]] == gameState[wingPosition[1]]
                && gameState[wingPosition[1]] == gameState[wingPosition[2]]
            ) {
                return true
            }
        }
        return false
    }

    // Sets up click listeners for all the buttons
    private fun setListener() {

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


    private fun click(button: Button) {
        if (button.text.isEmpty()) {//Checks if the button's text is empty
            button.text = currentSymbol // sets the button's text to the current symbol

            val buttonId = button.resources.getResourceEntryName(button.id)
            val gameStatePointer = buttonId.last().digitToInt()


            gameState[gameStatePointer] = if (currentSymbol == "X") 0 else 1

            gameState.forEach {
                println(it)
            }
            println("-------------")

            if (checkWinner()) {
                Toast.makeText(this@BoardActivity, "Won", Toast.LENGTH_LONG).show()
            }

            currentSymbol = if (currentSymbol == "X") "O" else "X"  //Toggle Current Symbol
        }
    }
}

package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var resultText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //referinta la textView
        resultText = findViewById(R.id.result_text)
        resultText?.text = "Dice Rolled!"

        //referinta la buton ca sa pot sa ii dau un click listener
        val rollButton: Button = findViewById(R.id.roll_button)

        //click listener
        rollButton.setOnClickListener{ rollDice() }

        val countUp: Button = findViewById(R.id.count_up)
        countUp.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice(){
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val randomInt = Random.nextInt(6)+1

        //aici setez cifra random sa fie textul din textView
        resultText?.text = randomInt.toString()
    }

    private fun reset(){
        resultText?.text = 0.toString()
    }

    private fun countUp(){
        val currentValue = resultText?.text

        when(currentValue){
            "Dice Rolled!" -> resultText?.text = 1.toString()
            "Hello World!" -> resultText?.text = 1.toString()
            "6" -> Toast.makeText(this, "6", Toast.LENGTH_SHORT).show()
            else -> {
                val nr = currentValue.toString().toInt()
                resultText?.text = (nr+1).toString()
                Toast.makeText(this, "Incremented", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

package com.example.diceroller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The findViewById() method finds the Button in the layout.
        // R.id.button is the resource ID for the Button, which is a unique identifier for it.
        // The code saves a reference to the Button object in a variable called rollButton, not the Button object itself.
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice()}
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }

//    fun main() {
//        val myFirstDice = Dice(6)
//        val mySecondDice = Dice(6)
//        val rollResult = myFirstDice.roll()
//        val rollResult2 = mySecondDice.roll()
//        val luckyNumber = (1..myFirstDice.numSides).random()
//        val luckyNumber2 = (1..mySecondDice.numSides).random()
//
//        when (rollResult) {
//            luckyNumber -> println("You win!")
//            1 -> println("So sorry! You rolled a 1. Try again!")
//            2 -> println("Sadly, you rolled a 2. Try again!")
//            3 -> println("Unfortunately, you rolled a 3. Try again!")
//            5 -> println("Don't cry! You rolled a 5. Try again!")
//            6 -> println("Apologies! you rolled a 6. Try again!")
//        }
//
//        when (rollResult2) {
//            luckyNumber2 -> println("You win!")
//            1 -> println("So sorry! You rolled a 1. Try again!")
//            2 -> println("Sadly, you rolled a 2. Try again!")
//            3 -> println("Unfortunately, you rolled a 3. Try again!")
//            5 -> println("Don't cry! You rolled a 5. Try again!")
//            6 -> println("Apologies! you rolled a 6. Try again!")
//        }
//
//        println("Your ${myFirstDice.numSides} sided dice rolled ${rollResult}!")
//        println("Your ${mySecondDice.numSides} sided dice rolled ${rollResult2}!")
//    }


}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}


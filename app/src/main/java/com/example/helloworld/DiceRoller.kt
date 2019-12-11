package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DiceRoller : AppCompatActivity() {
    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.reset_button)
        clearButton.setOnClickListener { diceImage.setImageResource(R.drawable.empty_dice) }

        val btnOpenActivity : Button = findViewById(R.id.about_me_button)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, AboutMe :: class.java)
            startActivity(intent)
        }
    }
    private fun rollDice() {

        val randomInt = kotlin.random.Random.nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

    }

}

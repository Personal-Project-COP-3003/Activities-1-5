package com.example.helloworld

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ColourView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colour_view)

        setListeners()


        val btnOpenActivity : Button = findViewById(R.id.android_trivia_button)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, AndroidTrivia :: class.java)
            startActivity(intent)
        }

    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for the background
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.mouse)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.smile)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.happy)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.androidlogo)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.neutral)

            // Boxes using custom colors for background
            R.id.red_button -> view.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> view.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> view.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)


        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}

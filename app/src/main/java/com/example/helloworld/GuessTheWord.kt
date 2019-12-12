package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GuessTheWord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_the_word)

        val btnOpenActivity : Button = findViewById(R.id.sleepTracker)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, SleepTracker :: class.java)
            startActivity(intent)
        }
    }
}

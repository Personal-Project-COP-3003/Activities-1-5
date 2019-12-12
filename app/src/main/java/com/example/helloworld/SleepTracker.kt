package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SleepTracker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_tracker)

        val btnOpenActivity : Button = findViewById(R.id.marsRealEstateButton)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, SleepTracker :: class.java)
            startActivity(intent)
        }
    }
}

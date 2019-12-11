package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.helloworld.databinding.ActivityAndroidTriviaBinding


class AndroidTrivia : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityAndroidTriviaBinding>(
            this,
            R.layout.activity_android_trivia
        )

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController ,drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

        val btnOpenActivity : Button = findViewById(R.id.dessert_activity_button)
        btnOpenActivity.setOnClickListener {
            val intent = Intent(this, DessertClicker :: class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}

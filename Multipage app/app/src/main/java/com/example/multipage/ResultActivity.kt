package com.example.multipage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val toHomeButton: Button = findViewById(R.id.homeButton)

        // Get all the selected pet information
        val dogName = intent.getStringExtra("dogName")
        val petName = intent.getStringExtra("petName")
        val collarName = intent.getStringExtra("collarName")
        val dogImage = intent.getIntExtra("dogImage", 0)
        val collarImage = intent.getIntExtra("collarImage", 0)

        val resultText: TextView = findViewById(R.id.congratsText)
        resultText.text = "You adopted $petName ~ a $dogName! 🎉"

        // Save the final information for the home screen
        val prefs = getSharedPreferences("DogApp", MODE_PRIVATE)

        prefs.edit()
            .putString("petName", petName)
            .putString("dogName", dogName)
            .putString("collarName", collarName)
            .putInt("dogImage", dogImage)
            .putInt("collarImage", collarImage)
            .apply()

        toHomeButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
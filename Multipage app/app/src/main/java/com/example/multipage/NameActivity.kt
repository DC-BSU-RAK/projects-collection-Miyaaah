package com.example.multipage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val toResultsButton: Button = findViewById(R.id.toresultsButton)
        val pupNameText: EditText = findViewById(R.id.pupNameText)

        // Get the dog and collar data sent from the previous pages
        val dogName = intent.getStringExtra("dogName")
        val dogImage = intent.getIntExtra("dogImage", 0)
        val collarImage = intent.getIntExtra("collarImage", 0)
        val collarName = intent.getStringExtra("collarName")

        // Show selected dog and collar images
        val dogImageView: ImageView = findViewById(R.id.dogImageTemp)
        val collarImageView: ImageView = findViewById(R.id.collarImageTemp)

        dogImageView.setImageResource(dogImage)
        collarImageView.setImageResource(collarImage)

        // Move to the results screen with the selected name
        toResultsButton.setOnClickListener {

            val petName = pupNameText.text.toString()

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("dogName", dogName)
            intent.putExtra("petName", petName)
            intent.putExtra("dogImage", dogImage)
            intent.putExtra("collarName", collarName)
            intent.putExtra("collarImage", collarImage)

            startActivity(intent)

        }
    }
}
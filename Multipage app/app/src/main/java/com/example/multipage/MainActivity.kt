package com.example.multipage

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!::mediaPlayer.isInitialized) {
            mediaPlayer = MediaPlayer.create(this, R.raw.mypupbgm)
            mediaPlayer.isLooping = true
        }
        // Start button
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            val intent = Intent(this, BreedActivity::class.java)
            startActivity(intent)
        }

        // Instructions popup window

        val instructButton: ImageButton = findViewById(R.id.instrButton)

        instructButton.setOnClickListener {

            val inflater =
                getSystemService(LAYOUT_INFLATER_SERVICE)
                        as LayoutInflater

            // POPUP
            val popupView =
                inflater.inflate(
                    R.layout.activity_my_pup_instructions, null
                )

            val instructWindow =
                PopupWindow(
                    popupView, 1000, 1200, true
                )

            instructWindow.showAtLocation(
                popupView,
                Gravity.CENTER, 0, 0
            )

            val closeButton: ImageButton =
                popupView.findViewById(R.id.closeButton)

            closeButton.setOnClickListener {
                instructWindow.dismiss()
            }
        }

        // Loads the saved dog information from SharedPreferences.
        val prefs = getSharedPreferences("DogApp", MODE_PRIVATE)

        val petName = prefs.getString("petName", null)
        val dogImage = prefs.getInt("dogImage", 0)
        val collarImage = prefs.getInt("collarImage", 0)
        val collarName = prefs.getString("collarName", null)

        // UI
        val homeText: TextView = findViewById(R.id.homeText)
        val homeDogImage: ImageView =
            findViewById(R.id.homeDogImage)

        val homeCollarImage: ImageView =
            findViewById(R.id.homeCollarImage)

        // Hide the images if there is no data
        homeDogImage.visibility = View.GONE
        homeCollarImage.visibility = View.GONE

        // Show the dog information if data exists
        if (petName != null) {

            homeText.text =
                "$petName is home! 🐶 They look adorable in their $collarName collar!"

            homeDogImage.setImageResource(dogImage)
            homeCollarImage.setImageResource(collarImage)

            homeDogImage.visibility = View.VISIBLE
            homeCollarImage.visibility = View.VISIBLE
        }
    }
    override fun onResume() {
        super.onResume()
        //   Start music when the user can actually see the screen
        if (::mediaPlayer.isInitialized && !mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        // Pause so it doesn't play over other activities
        if (::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }
}
package com.example.multipage

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CollarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collar)

        val dogName = intent.getStringExtra("dogName")
        val dogImage = intent.getIntExtra("dogImage", 0)

        // Collar styles buttons
        val leatherCollarButton: ImageButton = findViewById(R.id.leathercollarButton)
        val camouCollarButton: ImageButton = findViewById(R.id.camoucollarButton)
        val galaxyCollarButton: ImageButton = findViewById(R.id.galaxycollarButton)
        val spikyCollarButton: ImageButton = findViewById(R.id.spikycollarButton)
        val goldCollarButton: ImageButton = findViewById(R.id.goldcollarButton)
        val heartCollarButton: ImageButton = findViewById(R.id.heartcollarButton)

        // Open the naming screen and send the selected collar data
        fun goToName(collarName: String, collarImage: Int) {
            val intent = Intent(this, NameActivity::class.java)

            intent.putExtra("dogName", dogName)
            intent.putExtra("dogImage", dogImage)
            intent.putExtra("collarName", collarName)
            intent.putExtra("collarImage", collarImage)

            startActivity(intent)
        }

        // Play a bounce animation and move to the next screen when a collar is selected

        leatherCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            leatherCollarButton.startAnimation(animation)

            leatherCollarButton.postDelayed({
                goToName("Leather", R.drawable.leatherpng)
            }, 300)
        }

        camouCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            camouCollarButton.startAnimation(animation)

            camouCollarButton.postDelayed({
                goToName("Camouflage", R.drawable.campng)
            }, 300)
        }

        galaxyCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            galaxyCollarButton.startAnimation(animation)

            galaxyCollarButton.postDelayed({
                goToName("Galaxy", R.drawable.galaxypng)
            }, 300)
        }

        spikyCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            spikyCollarButton.startAnimation(animation)

            spikyCollarButton.postDelayed({
                goToName("Spiky", R.drawable.spikypng)
            }, 300)
        }

        goldCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            goldCollarButton.startAnimation(animation)

            goldCollarButton.postDelayed({
                goToName("Gold", R.drawable.goldpng)
            }, 300)
        }

        heartCollarButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            heartCollarButton.startAnimation(animation)

            heartCollarButton.postDelayed({
                goToName("Heart", R.drawable.heartpng)
            }, 300)
        }
    }
}
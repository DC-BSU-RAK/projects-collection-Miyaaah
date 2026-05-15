package com.example.multipage

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class BreedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed)

        //  Dog breed buttons
        val rottweilerButton: ImageButton = findViewById(R.id.rottweilerButton)
        val bichonButton: ImageButton = findViewById(R.id.bichonButton)
        val labradorButton: ImageButton = findViewById(R.id.labradorButton)
        val huskyButton: ImageButton = findViewById(R.id.huskyButton)
        val dachshundButton: ImageButton = findViewById(R.id.dachshundButton)
        val yorkieButton: ImageButton = findViewById(R.id.yorkieButton)

        //  Function to send dog data to collar page
        fun goToCollar(dogName: String, dogImage: Int) {

            val intent = Intent(this, CollarActivity::class.java)

            intent.putExtra("dogName", dogName)
            intent.putExtra("dogImage", dogImage)

            startActivity(intent)
        }

        // Click listeners with bounce animation
        rottweilerButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            rottweilerButton.startAnimation(animation)

            rottweilerButton.postDelayed({
                goToCollar("Rottweiler", R.drawable.rottweiler)
            }, 300)
        }

        bichonButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            bichonButton.startAnimation(animation)

            bichonButton.postDelayed({
                goToCollar("Bichon Frise", R.drawable.bichon)
            }, 300)
        }

        labradorButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            labradorButton.startAnimation(animation)

            labradorButton.postDelayed({
                goToCollar("Labrador", R.drawable.labrador_retriever)
            }, 300)
        }

        huskyButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            huskyButton.startAnimation(animation)

            huskyButton.postDelayed({
                goToCollar("Husky", R.drawable.husky)
            }, 300)
        }

        dachshundButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            dachshundButton.startAnimation(animation)

            dachshundButton.postDelayed({
                goToCollar("Dachshund", R.drawable.dachshund)
            }, 300)
        }

        yorkieButton.setOnClickListener {

            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)

            yorkieButton.startAnimation(animation)

            yorkieButton.postDelayed({
                goToCollar("Yorkshire Terrier", R.drawable.yorkie)
            }, 300)
        }
    }
}
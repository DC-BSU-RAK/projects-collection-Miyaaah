package com.example.cakecalculator

import android.os.Bundle
import android.media.MediaPlayer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Holds media player for background music
    private lateinit var mediaPlayer: MediaPlayer

    // User's cake selections
    private var shape = ""
    private var flavor = ""
    private var icing = ""
    private var topping = ""

    // Result display
    private lateinit var cakeResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeResult = findViewById(R.id.cakeResult)

        // bgm setup
        mediaPlayer = MediaPlayer.create(this, R.raw.cakepickbgm)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        //popup instructions button
        val instructButton : ImageButton = findViewById(R.id.instrButton)

        instructButton.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.instructions_popup, null)

            val instructWindow = PopupWindow(popupView, 1000, 1000, true)

            instructWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

            val closeButton : ImageButton = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener {
                instructWindow.dismiss()
            }
        }
    }

    //shape buttons
    fun onHeartClick(view: View) {
        shape = "Heart-shaped"
        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onCircleClick(view: View) {
        shape = "Round"
        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onSquareClick(view: View) {
        shape = "Square-shaped"
        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    //flavors button
    fun onChocoClick(view: View) {
        flavor = "Rich Chocolate"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onVanillaClick(view: View) {
        flavor = "Classic Vanilla"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onStrawberryClick(view: View) {
        flavor = "Sweet Strawberry"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    //icing buttons

    fun onMangoClick(view: View) {
        icing = "Mango glaze"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onUbeClick(view: View) {
        icing = "Ube cream"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onWhiteClick(view: View) {
        icing = "Classic white frosting"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    //toppings buttons

    fun onSprinklesClick(view: View) {
        topping = "Sprinkles"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onFruitsClick(view: View) {
        topping = "Fresh fruits"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    fun onCreamClick(view: View) {
        topping = "Whipped cream"

        val anim = AnimationUtils.loadAnimation(this, R.anim.bounce)
        view.startAnimation(anim)
    }

    //confirm selection button
    fun onFinishCakeClick(view: View) {

        if (shape == "" || flavor == "" || icing == "" || topping == "") {
            cakeResult.text = "Please select all options first!"
        } else {
            val result = "🎂 Your $shape $flavor cake with $icing icing and $topping is ready!"
            cakeResult.text = result

        }
    }
}
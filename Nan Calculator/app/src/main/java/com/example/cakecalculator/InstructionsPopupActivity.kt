package com.example.cakecalculator

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InstructionsPopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_popup)

        val closeButton: ImageButton = findViewById(R.id.closeButton)

        closeButton.setOnClickListener {
            finish()
        }
    }
}
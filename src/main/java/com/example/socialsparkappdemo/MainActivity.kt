@file:Suppress("DEPRECATION")

package com.example.socialsparkappdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<android.widget.EditText>(R.id.editTextTime)
        val suggestButton = findViewById<android.widget.Button>(R.id.buttonSuggest)
        val resetButton = findViewById<android.widget.Button>(R.id.buttonReset)
        val resultText = findViewById<android.widget.TextView>(R.id.TextViewSuggestion)
        val btnGood = findViewById<android.widget.Button>(R.id.btnGood)
        val btnNotGood = findViewById<android.widget.Button>(R.id.btnNotGood)
        val moodResponse = findViewById<android.widget.TextView>(R.id.MoodResponse)
        val typingEffect = findViewById<android.widget.TextView>(R.id.TypingEffect)

        // Mood button logic

        btnGood.setOnClickListener {
            moodResponse.text = "That's awesome! Lets make today even more exciting✨"
        }
        btnNotGood.setOnClickListener {
            moodResponse.text =
                "Hey,it's okay to have off days. You're doing your bestand that's enough✨"
        }


        // Suggest button logic
        suggestButton.setOnClickListener {

            val input = timeInput.text.toString().trim()

            if (input.isEmpty()) {
                resultText.text = "Please enter a time of day"
                return@setOnClickListener
            }

            typingEffect.visibility = android.view.View.VISIBLE
            resultText.text = "Generating suggestion..."
            android.os.Handler().postDelayed({
                var message:String

                if (input.equals("Morning", true)){
                    message = "Morning ☀️ Send a good morning message."

                } else if (input.equals("Mid-Morning", true)) {
                    message = "Mid-Morning ☕ Check in with a friend."

                } else if (input.equals("Afternoon", true)) {
                    message = "Afternoon 📚 Plan lunch with someone."

                } else if (input.equals("Mid-Afternoon", true)) {
                    message = "Mid-Afternoon 🍪 Have quick chat with someone"

                } else if (input.equals("Dinner", true)) {
                    message = "Dinner 🍝 Invite someone for dinner"

                } else if (input.equals("After Dinner", true)) {
                    message = "After Dinner 🌙 Send a good night message."

                } else {
                    message =
                        "Invalid input. Please enter: Morning, Mid-Morning, Afternoon, Mid-Afternoon, Dinner, or After Dinner."
                }
                typingEffect.visibility = android.view.View.GONE
                resultText.text = message
            }, 2000)
        }
        // Reset button
        resetButton.setOnClickListener {
            timeInput.text.clear()
            resultText.text = "Suggestion will appear here"
            typingEffect.visibility = android.view.View.GONE
            moodResponse.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}




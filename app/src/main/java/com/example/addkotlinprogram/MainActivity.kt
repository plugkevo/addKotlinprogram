package com.example.addkotlinprogram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var buttonAdd: Button
    private lateinit var tvResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views after setting content view
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        buttonAdd = findViewById(R.id.buttonAdd)
        tvResults = findViewById(R.id.tvResults)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listener using a lambda
        buttonAdd.setOnClickListener { view ->
            try {
                val num1Value = num1.text.toString().toDouble()
                val num2Value = num2.text.toString().toDouble()
                val sum = num1Value + num2Value
                tvResults.text = sum.toString()
            } catch (e: NumberFormatException) {
                tvResults.text = "Please enter valid numbers."
            }
        }
    }
}
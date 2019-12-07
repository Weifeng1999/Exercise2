package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calculateBMI(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            resetBMI(it)
        }
    }

    private fun calculateBMI(view: View){
        val weight = findViewById<EditText>(R.id.editTextWeight).text.toString().toDouble()
        val height = findViewById<EditText>(R.id.editTextHeight).text.toString().toDouble()
        val bmi = weight / (height * height)

        when {
            bmi < 18.5 -> {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.under)
            }
            bmi in 18.5..24.9 -> {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.normal)
            }
            else -> {
                findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.over)
            }
        }
        findViewById<TextView>(R.id.textViewBMI).text = "BMI :$bmi"
    }

    private fun resetBMI(view: View){
        findViewById<EditText>(R.id.editTextWeight).text.clear()
        findViewById<EditText>(R.id.editTextHeight).text.clear()
        findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)
        findViewById<TextView>(R.id.textViewBMI).text = "BMI :"
    }
}

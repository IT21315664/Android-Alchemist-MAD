package com.example.career.activities

import android.content.Intent

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.career.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var beach = findViewById<CardView>(R.id.crd1)
        beach.setOnClickListener {
            val intent = Intent(this, CareerDetails::class.java)
            startActivity(intent)

        }

    }

}
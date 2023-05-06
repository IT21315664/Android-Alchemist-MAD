package com.example.career.activities

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.career.R

class CareerDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career_details)

        val click = findViewById<Button>(R.id.btnApply)
        click.setOnClickListener {

            val intentApply = Intent(this, insertandfetch::class.java)
            startActivity(intentApply)
        }
    }
}
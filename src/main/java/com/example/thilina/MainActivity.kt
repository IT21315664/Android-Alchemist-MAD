package com.example.thilina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var nextBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nextBtn = findViewById(R.id.nextBtn)


        nextBtn.setOnClickListener {
            val intent = Intent(this, page2::class.java)
            startActivity(intent)
        }
    }
}
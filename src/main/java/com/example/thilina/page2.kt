package com.example.thilina

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page2 : AppCompatActivity() {
    private lateinit var btnagain :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)


        btnagain = findViewById<Button>(R.id.btnagain)
   btnagain.setOnClickListener {
            val next = Intent(this, marinaDistrict::class.java)
            startActivity(next)
        }


    }
}
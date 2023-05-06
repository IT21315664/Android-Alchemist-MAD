package com.example.career.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.career.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class insertandfetch : AppCompatActivity() {

    private lateinit var btnInsert: Button
    private lateinit var btnFetch: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertandfetch)

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()



        btnInsert = findViewById(R.id.btnInsert)
        btnFetch = findViewById(R.id.btnFetch)

        btnInsert.setOnClickListener {
            val intent = Intent(this, form::class.java)
            startActivity(intent)
        }
        btnFetch.setOnClickListener {
            val intent = Intent(this, FetchDetails::class.java)
            startActivity(intent)
        }




    }
}
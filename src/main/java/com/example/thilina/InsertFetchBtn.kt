package com.example.thilina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertFetchBtn : AppCompatActivity() {

    private lateinit var btnInsert: Button
    private lateinit var btnFetch :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_fetch_btn)

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        btnInsert= findViewById<Button>(R.id.btnInsert)
        btnInsert.setOnClickListener {
            val next = Intent(this, hotelPlot::class.java)
            startActivity(next)
        }
        btnFetch= findViewById<Button>(R.id.btnFetch)
        btnFetch.setOnClickListener {
            val next = Intent(this, FetchActivity::class.java)
            startActivity(next)
        }


    }
}
package com.example.pp4_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addToInvButton = findViewById<View>(R.id.addToInventoryNext)
        addToInvButton.setOnClickListener {
            startActivity(Intent(this, AddItemToDataBasePage::class.java))
        }
    }
}
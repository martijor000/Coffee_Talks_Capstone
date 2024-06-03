package com.example.captone_coffee_talk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HomePage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page) // Assuming home_page.xml is your layout file
        val profileBtn = findViewById<ImageButton>(R.id.profileButton)
        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
        val homeBtn = findViewById<ImageButton>(R.id.homeButton)
        homeBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    } // Other methods and logic specific to your HomePage class
}

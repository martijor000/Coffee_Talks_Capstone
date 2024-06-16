package com.example.captone_coffee_talk

import FirestoreManager
import FirestoreService
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

 class HomePage : Activity() {
    private val firestoreService = FirestoreService()
    private val  auth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirestoreManager.initialize()
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
        val firestore = FirestoreManager.getFirestore()
        val results = firestoreService.getDocument("block", "YBLailbCxo05yGyuCxHW")
        print(results)
    } // Other methods and logic specific to your HomePage class

}

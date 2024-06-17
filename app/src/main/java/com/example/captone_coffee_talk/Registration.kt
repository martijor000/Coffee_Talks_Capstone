package com.example.captone_coffee_talk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.captone_coffee_talk.databinding.ActivityRegistrationBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User

class Registration : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    //private lateinit var db: FirebaseFirestore

    private lateinit var username :EditText
    private lateinit var email :EditText
    private lateinit var password :EditText
    private lateinit var confirmPassword :EditText
    private lateinit var registrationBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        username = findViewById(R.id.registration_Username)
        email = findViewById(R.id.registration_email)
        password = findViewById(R.id.registration_password)
        confirmPassword = findViewById(R.id.registration_confirm_password)
        registrationBtn = findViewById(R.id.registration_save)

        binding.registrationSave.setOnClickListener {
            signUp()
        }
    }
    private fun signUp() {
        val username = username.text.toString()
        val password = password.text.toString()
        val email = email.text.toString()
        val confirmPassword = confirmPassword.text.toString()

        if (username.isBlank() || password.isBlank() || email.isBlank()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }
        if (password != confirmPassword){
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            return
        }
        fun writeNewUser( ) {
            val ref = FirebaseDatabase.getInstance().getReference("/user/")
            val user = Firebase.auth.currentUser
            ref.setValue(user)
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully created", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
               // writeNewUser()
                finish()
            } else {
                Toast.makeText(this, "Sign up Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}


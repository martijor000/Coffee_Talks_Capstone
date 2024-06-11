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
import com.google.firebase.firestore.FirebaseFirestore

class Registration : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth

    lateinit var username :EditText
    lateinit var email :EditText
    lateinit var password :EditText
    lateinit var confirmPassword :EditText
    lateinit var registrationBtn : Button
    lateinit var redirectLogin: TextView

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
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully created", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Sign up Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


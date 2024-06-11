package com.example.captone_coffee_talk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.captone_coffee_talk.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login :  AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set val
        email =findViewById(R.id.login_email)
        password = findViewById(R.id.login_password)
        loginButton = findViewById(R.id.activity_log_in_login_button)

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener{
            login()
        }
//
        binding.activityLogInRegisterButton.setOnClickListener{
            startActivity(Intent(this, Registration::class.java))
            finish()
        }
    }
    private fun login(){
        val email = email.text.toString()
        val password = password.text.toString()
        // firebase function
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            else
                Toast.makeText(baseContext, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}
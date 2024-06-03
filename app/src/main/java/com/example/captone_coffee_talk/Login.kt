package com.example.captone_coffee_talk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.captone_coffee_talk.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityLogInLoginButton.setOnClickListener{
            val LoginEmail = binding.loginEmail.text.toString()
            val LoginPassword = binding.loginPassword.text.toString()

            if (LoginEmail == "123@.com"
                && LoginPassword == "123") {
                Toast.makeText(applicationContext, "Your Login is Successful!", Toast.LENGTH_SHORT).show()
            }
            else   {
                Toast.makeText(this , "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
        binding.activityLogInRegisterButton.setOnClickListener{
            startActivity(Intent(this, Registration::class.java))
            finish()
        }
    }
}
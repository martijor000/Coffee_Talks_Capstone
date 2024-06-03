package com.example.captone_coffee_talk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.captone_coffee_talk.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registrationSave.setOnClickListener {
            val username = binding.registrationName
            val password = binding.registrationPassword
            val email = binding.registrationEmail

            if (username != null && password != null && email != null) {
                Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Login::class.java))
            }
        }
    }
}
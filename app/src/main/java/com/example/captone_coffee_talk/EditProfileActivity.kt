package com.example.captone_coffee_talk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.captone_coffee_talk.databinding.ActivityEditprofileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditprofileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditprofileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSave.setOnClickListener {
            // Get the updated profile data from the input fields
            val updatedMajorName = binding.editTextMajorName.text.toString()
            val updatedCollegeName = binding.editTextCollegeName.text.toString()
            val updatedAge = binding.editTextAge.text.toString()
            val updatedUserEmail = binding.editTextEmail.text.toString()

        }
    }
}
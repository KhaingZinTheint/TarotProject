package com.example.tarotproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotproject.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)

        binding.signUpButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Insert user data into the database
                val userId = dbHelper.insertUser(email, password)

                if (userId != -1L) {
                    // Show success message
                    Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()

                    // Redirect to LoginActivity after successful signup
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()  // Close SignUpActivity so user can't return to it by pressing back
                } else {
                    // Show failure message
                    Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Show validation error
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

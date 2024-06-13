package com.example.projectmobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailUsernameEditText = findViewById<EditText>(R.id.email_username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password)
        val contactAdminTextView = findViewById<TextView>(R.id.contact_admin)

        loginButton.setOnClickListener {
            val emailUsername = emailUsernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Implement login logic here
            if (emailUsername.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter email/username and password", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordTextView.setOnClickListener {
            // Implement forgot password logic here
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
        }

        contactAdminTextView.setOnClickListener {
            // Implement contact admin logic here
            Toast.makeText(this, "Contact Admin Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}

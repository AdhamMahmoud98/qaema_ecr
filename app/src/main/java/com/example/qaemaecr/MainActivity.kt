package com.example.qaemaecr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val submitButton: Button = findViewById(R.id.btnSubmit)
        val firstName: TextView = findViewById(R.id.etFirstName)
        val lastName: TextView = findViewById(R.id.etLastName)
        val birthDate: TextView = findViewById(R.id.etBirthDate)
        val country: TextView = findViewById(R.id.etCountry)

        submitButton.setOnClickListener {
//            val firstNameText = firstName.text.toString()
//            val lastNameText = lastName.text.toString()
//            val birthDateText = birthDate.text.toString()
//            val countryText = country.text.toString()
//
//            Log.d("mainActivity", "$firstNameText $lastNameText $birthDateText $countryText")

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}

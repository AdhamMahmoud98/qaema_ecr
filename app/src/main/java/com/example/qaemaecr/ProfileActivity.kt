package com.example.qaemaecr

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val languageButton = findViewById<ConstraintLayout>(R.id.languageButtonContainer)

        languageButton.setOnClickListener {
            val currentLanguage = LanguageUtils.getCurrentLanguage(this)
            Log.d("CurrentLang", currentLanguage)
            val newLanguage = if (currentLanguage == "en") "ar" else "en"
            Log.d("NewLang", newLanguage)
            LanguageUtils.updateLocale(this, newLanguage)

            val sharedPreferences = getSharedPreferences(LanguageUtils.LANGUAGE_PREFS, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(LanguageUtils.LANGUAGE_KEY, newLanguage)
            editor.apply()

            // Recreate the activity with the updated language
            val intent = Intent(this, ProfileActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}

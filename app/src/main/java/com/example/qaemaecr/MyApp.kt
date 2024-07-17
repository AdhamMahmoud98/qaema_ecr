package com.example.qaemaecr

import android.app.Application
import android.content.Context

class MyApp : Application() {
    override fun attachBaseContext(base: Context?) {
        val language = LanguageUtils.getCurrentLanguage(base!!)
        val updatedContext = LanguageUtils.updateLocale(base, language)
        super.attachBaseContext(updatedContext)
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize any other components here if needed
    }
}

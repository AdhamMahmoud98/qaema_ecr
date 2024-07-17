package com.example.qaemaecr

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import java.util.Locale

class LanguageUtils {
    companion object {
        const val LANGUAGE_PREFS = "language_prefs"
        const val LANGUAGE_KEY = "language"

        fun getCurrentLanguage(context: Context): String {
            val sharedPreferences = context.getSharedPreferences(LANGUAGE_PREFS, Context.MODE_PRIVATE)
            return sharedPreferences.getString(LANGUAGE_KEY, Locale.getDefault().language) ?: Locale.getDefault().language
        }

        fun updateLocale(context: Context, language: String): Context {
            val locale = Locale(language)
            Locale.setDefault(locale)

            val configuration = Configuration()
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)

            val resources = context.resources
            resources.updateConfiguration(configuration, resources.displayMetrics)

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                LocaleList.setDefault(LocaleList(locale))
                context.createConfigurationContext(configuration)
            } else {
                resources.updateConfiguration(configuration, resources.displayMetrics)
                context
            }
        }
    }
}

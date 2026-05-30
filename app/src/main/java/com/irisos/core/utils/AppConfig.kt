package com.irisos.core.utils

import android.content.Context
import android.util.Log

object AppConfig {
    private const val TAG = "AppConfig"
    var status: ConfigStatus = ConfigStatus.INITIALIZING
        private set

    fun initialize(context: Context) {
        Log.i(TAG, "Initializing AppConfig...")
        // Placeholder for ENV reading logic (e.g., from BuildConfig or Assets)
        
        val hasFirebase = checkFirebaseState()
        val hasAI = checkAIProviderState()
        
        status = if (hasFirebase && hasAI) {
            ConfigStatus.READY
        } else {
            ConfigStatus.MISSING_CONFIG
        }
        Log.i(TAG, "AppConfig Status: $status")
    }

    fun isDebug(): Boolean = true // Mocked

    private fun checkFirebaseState(): Boolean {
        // Placeholder check
        return true
    }

    private fun checkAIProviderState(): Boolean {
        // Placeholder check
        return true
    }
}
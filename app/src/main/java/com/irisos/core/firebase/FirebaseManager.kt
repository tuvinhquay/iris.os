package com.irisos.core.firebase

import android.content.Context
import com.google.firebase.FirebaseApp
import com.irisos.core.logs.IRISLogger

object FirebaseManager {
    private var isInitialized = false

    fun initialize(context: Context) {
        if (isInitialized) return
        
        try {
            IRISLogger.runtime("Initializing Firebase Foundation...")
            FirebaseApp.initializeApp(context)
            isInitialized = true
            IRISLogger.runtime("Firebase Initialized Successfully")
        } catch (e: Exception) {
            IRISLogger.runtime("Firebase Initialization Failed: ${e.message}")
            // Fallback for missing google-services.json
            isInitialized = false
        }
    }

    fun isReady(): Boolean = isInitialized
}
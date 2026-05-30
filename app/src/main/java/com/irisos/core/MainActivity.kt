package com.irisos.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.irisos.core.firebase.FirebaseManager
import com.irisos.core.ui.screens.MainDashboardScreen
import com.irisos.core.ui.theme.IRISOSTheme
import com.irisos.core.utils.AppConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Foundation Systems
        AppConfig.initialize(this)
        FirebaseManager.initialize(this)
        
        enableEdgeToEdge()
        setContent {
            IRISOSTheme {
                MainDashboardScreen()
            }
        }
    }
}

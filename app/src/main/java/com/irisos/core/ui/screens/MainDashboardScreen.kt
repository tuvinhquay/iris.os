package com.irisos.core.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.irisos.core.automation.AutomationManager
import com.irisos.core.automation.AntiStuckManager
import com.irisos.core.engine.GameStateManager
import com.irisos.core.utils.AppConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("IRIS OS Dashboard") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Text("AI Automation Logic", style = MaterialTheme.typography.titleLarge) }
            item { StatusCard("Game State", GameStateManager.getCurrentState().name) }
            item { StatusCard("Planned Action", "CLAIM_REWARD (Mock)") }
            item { StatusCard("Anti-Stuck", if (AntiStuckManager.isStuck()) "STUCK" else "OK") }
            
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { Text("Vision & OCR Engine", style = MaterialTheme.typography.titleLarge) }
            item { StatusCard("Vision Pipeline", "ACTIVE") }
            item { StatusCard("Last Detected", "Quest Complete") }
            
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item { Text("Foundation Status", style = MaterialTheme.typography.titleLarge) }
            item { StatusCard("AI Core", "READY") }
            item { StatusCard("Firebase", "CONNECTED") }
            item { StatusCard("Automation", AutomationManager.getRuntimeState()) }
            
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { 
                Button(onClick = { /* Start Automation Flow */ }, modifier = Modifier.fillMaxWidth()) {
                    Text("Start Automation")
                }
            }
        }
    }
}

@Composable
fun StatusCard(label: String, status: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = label, style = MaterialTheme.typography.titleMedium)
            Text(
                text = status, 
                style = MaterialTheme.typography.bodyMedium, 
                color = if (status == "OK" || status == "ACTIVE" || status == "READY")
                    MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        }
    }
}
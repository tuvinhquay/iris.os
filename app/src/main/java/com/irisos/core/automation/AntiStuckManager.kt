package com.irisos.core.automation

import com.irisos.core.logs.IRISLogger

object AntiStuckManager {
    private var lastStateChangeTime = System.currentTimeMillis()
    private var stuckThreshold = 30000L // 30 seconds

    fun isStuck(): Boolean {
        val currentTime = System.currentTimeMillis()
        val timeSinceLastChange = currentTime - lastStateChangeTime
        return timeSinceLastChange > stuckThreshold
    }

    fun handleStuck() {
        IRISLogger.w("AntiStuck: System is stuck! Attempting recovery...")
        // Recovery logic: Back button, Home, or Reset Flow
        lastStateChangeTime = System.currentTimeMillis() // Reset timer after handling
    }

    fun notifyStateChange() {
        lastStateChangeTime = System.currentTimeMillis()
    }
}
package com.irisos.core.automation

import com.irisos.core.ai.TaskPlanner
import com.irisos.core.engine.GameStateManager
import com.irisos.core.logs.IRISLogger
import com.irisos.core.memory.MemoryManager
import com.irisos.core.vision.analyzer.VisionAnalyzer
import kotlinx.coroutines.delay

object GameStateMachine {
    private var isRunning = false

    suspend fun startFlow() {
        if (isRunning) return
        isRunning = true
        IRISLogger.automation("GameStateMachine: Starting automation flow")
        
        while (isRunning) {
            // 1. Analyze current screen (Updates Vision and GameState)
            VisionAnalyzer.analyzeCurrentScreen()
            
            val currentState = GameStateManager.getCurrentState()
            
            // 2. Anti-Stuck Check
            if (AntiStuckManager.isStuck()) {
                AntiStuckManager.handleStuck()
                MemoryManager.recordRuntimeEvent(currentState, com.irisos.core.ai.ActionType.NONE, isStuck = true)
                delay(2000)
                continue
            }

            // 3. Plan next action based on current state & vision
            // In a real scenario, we'd pass OCR results here
            val action = TaskPlanner.planNextAction(currentState, null, emptyList())
            
            // 4. Anti-Loop Check
            if (AntiLoopManager.isLooping()) {
                IRISLogger.w("GameStateMachine: Loop detected, forcing cool down...")
                delay(5000)
                AntiLoopManager.clearHistory()
                continue
            }

            // 5. Execute action
            ActionEngine.executeAction(action)
            
            // 6. Record to Memory
            MemoryManager.recordRuntimeEvent(currentState, action.type, isStuck = false)
            
            delay(2000) // Heartbeat delay
        }
    }

    fun stopFlow() {
        isRunning = false
        IRISLogger.automation("GameStateMachine: Stopping automation flow")
    }
    
    fun isActive(): Boolean = isRunning
}
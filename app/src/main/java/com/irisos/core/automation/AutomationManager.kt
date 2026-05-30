package com.irisos.core.automation

import com.irisos.core.logs.IRISLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object AutomationManager {
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    
    private val _isRunning = MutableStateFlow(false)
    val isRunning = _isRunning.asStateFlow()

    fun toggleAutomation() {
        if (_isRunning.value) {
            stopTask()
        } else {
            startTask("MAIN_FLOW")
        }
    }

    fun startTask(taskId: String) {
        if (_isRunning.value) return
        
        IRISLogger.automation("Starting automation task: $taskId")
        _isRunning.value = true
        
        scope.launch(Dispatchers.Default) {
            try {
                GameStateMachine.startFlow()
            } catch (e: Exception) {
                IRISLogger.runtime("Automation Error: ${e.message}")
                _isRunning.value = false
            }
        }
    }

    fun stopTask() {
        IRISLogger.automation("Stopping automation engine.")
        GameStateMachine.stopFlow()
        _isRunning.value = false
    }

    fun getRuntimeState(): String {
        return if (_isRunning.value) "RUNNING" else "IDLE"
    }
}
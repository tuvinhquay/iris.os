package com.irisos.core.memory

import com.irisos.core.logs.IRISLogger
import com.irisos.core.engine.GameState
import com.irisos.core.ai.ActionType

object MemoryManager {
    private const val PLAYER_MEMORY_FILE = "player_memory.json"
    private const val TASK_HISTORY_FILE = "task_history.json"
    private const val VISION_HISTORY_FILE = "vision_history.json"
    private const val RUNTIME_HISTORY_FILE = "runtime_history.json"

    fun loadPlayerMemory(): String = "{}"

    fun saveVisionState(text: String, popupVisible: Boolean, state: String) {
        IRISLogger.runtime("Memory: Saving vision state...")
    }

    fun recordRuntimeEvent(state: GameState, action: ActionType, isStuck: Boolean) {
        IRISLogger.runtime("Memory: Recording runtime event - State: $state, Action: $action, Stuck: $isStuck")
        // Placeholder for JSON append logic to runtime_history.json
    }

    fun saveState(key: String, value: String) {
        IRISLogger.runtime("Saving runtime state: $key")
    }
}
package com.irisos.core.automation

import com.irisos.core.ai.ActionType
import com.irisos.core.logs.IRISLogger

object AntiLoopManager {
    private val actionHistory = mutableListOf<ActionType>()
    private val maxHistory = 10
    private val loopThreshold = 3

    fun recordAction(actionType: ActionType) {
        actionHistory.add(actionType)
        if (actionHistory.size > maxHistory) {
            actionHistory.removeAt(0)
        }
    }

    fun isLooping(): Boolean {
        if (actionHistory.size < loopThreshold * 2) return false
        
        // Simple check: are the last N actions identical?
        val lastActions = actionHistory.takeLast(loopThreshold)
        val firstAction = lastActions.firstOrNull() ?: return false
        
        val isAllSame = lastActions.all { it == firstAction && it != ActionType.NONE }
        if (isAllSame) {
            IRISLogger.w("AntiLoop: Detected repeating action: $firstAction")
        }
        return isAllSame
    }

    fun clearHistory() {
        actionHistory.clear()
    }
}
package com.irisos.core.engine

import com.irisos.core.logs.IRISLogger
import com.irisos.core.automation.AntiStuckManager

enum class GameState {
    IDLE,
    MAIN_MENU,
    IN_GAME,
    QUEST_SCREEN,
    INVENTORY,
    REWARD_SCREEN,
    POPUP,
    LOADING,
    ERROR_STATE
}

object GameStateManager {
    private var currentState: GameState = GameState.IDLE
    private var previousState: GameState = GameState.IDLE
    private val history = mutableListOf<GameState>()

    fun updateState(newState: GameState) {
        if (currentState != newState) {
            previousState = currentState
            currentState = newState
            history.add(newState)
            if (history.size > 50) history.removeAt(0)
            
            // Notify Anti-Stuck that state has changed
            AntiStuckManager.notifyStateChange()
            
            IRISLogger.runtime("GameState: Changed from $previousState to $currentState")
        }
    }

    fun getCurrentState(): GameState = currentState
    fun getPreviousState(): GameState = previousState
    fun getHistory(): List<GameState> = history
}
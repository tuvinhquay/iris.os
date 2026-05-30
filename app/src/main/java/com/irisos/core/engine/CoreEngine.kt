package com.irisos.core.engine

import com.irisos.core.logs.IRISLogger

object CoreEngine {
    private var state: RuntimeState = RuntimeState.INITIALIZING

    fun start() {
        IRISLogger.runtime("CoreEngine: Starting...")
        state = RuntimeState.READY
    }

    fun updateState(newState: RuntimeState) {
        IRISLogger.runtime("CoreEngine: State changed from $state to $newState")
        state = newState
    }

    fun getCurrentState(): RuntimeState = state
}
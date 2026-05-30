package com.irisos.core.ai

import com.irisos.core.logs.IRISLogger
import kotlinx.coroutines.delay

class GeminiProvider {
    suspend fun generateResponse(prompt: String): String {
        IRISLogger.ai("GeminiProvider: Generating response for prompt...")
        // Mocking API call with delay
        delay(1000)
        return "Mocked AI Response for: $prompt"
    }
}
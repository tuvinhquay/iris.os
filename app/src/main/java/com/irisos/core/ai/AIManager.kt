package com.irisos.core.ai

import com.irisos.core.logs.IRISLogger

object AIManager {
    private val provider = GeminiProvider()

    suspend fun processTask(taskDescription: String): String {
        IRISLogger.ai("Processing task: $taskDescription")
        val prompt = PromptEngine.buildAutomationPrompt(taskDescription, "Game context placeholder")
        
        return try {
            val response = provider.generateResponse(prompt)
            IRISLogger.ai("AI Task completed successfully")
            response
        } catch (e: Exception) {
            IRISLogger.e("AI Task failed: ${e.message}")
            "Error: ${e.message}"
        }
    }
}
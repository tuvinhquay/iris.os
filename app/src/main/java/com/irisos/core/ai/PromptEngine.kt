package com.irisos.core.ai

import com.irisos.core.logs.IRISLogger

object PromptEngine {
    fun buildAutomationPrompt(taskDescription: String, context: String): String {
        IRISLogger.ai("Building prompt for task: $taskDescription")
        return """
            System: You are IRIS OS AI Agent.
            Context: $context
            Task: $taskDescription
            Instruction: Provide a step-by-step automation plan in JSON format.
        """.trimIndent()
    }
}
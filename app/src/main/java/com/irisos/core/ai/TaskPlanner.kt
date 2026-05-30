package com.irisos.core.ai

import com.irisos.core.engine.GameState
import com.irisos.core.vision.detector.DetectionBox
import com.irisos.core.vision.detector.DetectionType
import com.irisos.core.vision.ocr.OCRResult
import com.irisos.core.logs.IRISLogger

object TaskPlanner {
    fun planNextAction(
        currentState: GameState,
        ocrResult: OCRResult?,
        detections: List<DetectionBox>
    ): TaskAction {
        IRISLogger.ai("TaskPlanner: Planning next action for state $currentState")

        // 1. Check for popups/rewards first (high priority)
        val claimButton = detections.find { it.type == DetectionType.BUTTON && it.label.contains("Claim", ignoreCase = true) }
        if (claimButton != null) {
            return TaskAction(ActionType.CLAIM_REWARD, "Claim Button", claimButton.bounds.centerX(), claimButton.bounds.centerY())
        }

        // 2. Check OCR for specific keywords
        ocrResult?.let {
            if (it.fullText.contains("Quest Complete", ignoreCase = true)) {
                return TaskAction(ActionType.OPEN_QUEST, "Quest Complete Text")
            }
        }

        // 3. State based default actions
        return when (currentState) {
            GameState.MAIN_MENU -> TaskAction(ActionType.TAP, "Start Game", 500, 500) // Mock coords
            GameState.REWARD_SCREEN -> TaskAction(ActionType.CLOSE_POPUP, "Close Reward")
            else -> TaskAction(ActionType.NONE)
        }
    }
}
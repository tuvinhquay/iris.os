package com.irisos.core.vision.analyzer

import com.irisos.core.logs.IRISLogger
import com.irisos.core.vision.detector.UIDetector
import com.irisos.core.vision.ocr.OCRManager
import com.irisos.core.vision.capture.ScreenCaptureManager
import com.irisos.core.engine.GameStateManager
import com.irisos.core.engine.GameState
import com.irisos.core.vision.detector.DetectionType

object VisionAnalyzer {
    fun analyzeCurrentScreen() {
        IRISLogger.runtime("VisionAnalyzer: Starting full screen analysis...")
        
        val capture = ScreenCaptureManager.captureScreen()
        val bitmap = capture.bitmap ?: return
        
        val ocrResult = OCRManager.scanText(bitmap)
        val detections = UIDetector.detectElements(bitmap)
        
        IRISLogger.runtime("VisionAnalyzer: Found ${ocrResult.elements.size} text elements and ${detections.size} UI elements.")
        
        // Update Game State based on detections (Mock logic)
        val newState = when {
            UIDetector.isPopupVisible(detections) -> GameState.POPUP
            ocrResult.fullText.contains("Reward", ignoreCase = true) -> GameState.REWARD_SCREEN
            ocrResult.fullText.contains("Quest", ignoreCase = true) -> GameState.QUEST_SCREEN
            else -> GameState.IN_GAME
        }
        
        GameStateManager.updateState(newState)
        
        // Integration with Memory (Mock)
        saveToVisionHistory(ocrResult.fullText, UIDetector.isPopupVisible(detections))
    }

    private fun saveToVisionHistory(text: String, popupVisible: Boolean) {
        IRISLogger.runtime("VisionAnalyzer: Saving results to vision_history.json")
        // Placeholder for MemoryManager.saveVisionState(...)
    }
}
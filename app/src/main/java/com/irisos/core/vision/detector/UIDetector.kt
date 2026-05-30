package com.irisos.core.vision.detector

import android.graphics.Bitmap
import android.graphics.Rect
import com.irisos.core.logs.IRISLogger

object UIDetector {
    fun detectElements(bitmap: Bitmap): List<DetectionBox> {
        IRISLogger.runtime("Vision: Detecting UI elements...")
        
        // Mock detection results
        return listOf(
            DetectionBox(
                label = "Claim Button",
                bounds = Rect(400, 500, 500, 550),
                confidence = 0.95f,
                type = DetectionType.BUTTON
            ),
            DetectionBox(
                label = "Reward Popup",
                bounds = Rect(200, 200, 600, 600),
                confidence = 0.90f,
                type = DetectionType.POPUP
            )
        )
    }

    fun isPopupVisible(elements: List<DetectionBox>): Boolean {
        return elements.any { it.type == DetectionType.POPUP }
    }
}
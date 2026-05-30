package com.irisos.core.vision.overlay

import com.irisos.core.vision.detector.DetectionBox
import com.irisos.core.vision.ocr.TextElement

data class OverlayState(
    val isVisible: Boolean = false,
    val detectedBoxes: List<DetectionBox> = emptyList(),
    val detectedText: List<TextElement> = emptyList(),
    val fps: Int = 0,
    val lastSync: Long = System.currentTimeMillis()
)
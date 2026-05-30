package com.irisos.core.vision.detector

import android.graphics.Rect

data class DetectionBox(
    val label: String,
    val bounds: Rect,
    val confidence: Float,
    val type: DetectionType
)

enum class DetectionType {
    BUTTON,
    POPUP,
    NOTIFICATION,
    QUEST_PANEL,
    REWARD_SCREEN,
    UNKNOWN
}
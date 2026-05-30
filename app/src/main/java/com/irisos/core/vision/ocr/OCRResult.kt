package com.irisos.core.vision.ocr

import android.graphics.Rect

data class OCRResult(
    val fullText: String,
    val elements: List<TextElement>,
    val timestamp: Long = System.currentTimeMillis()
)

data class TextElement(
    val text: String,
    val bounds: Rect,
    val confidence: Float
)
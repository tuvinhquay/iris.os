package com.irisos.core.vision.ocr

import android.graphics.Bitmap
import android.graphics.Rect
import com.irisos.core.logs.IRISLogger

object OCRManager {
    fun scanText(bitmap: Bitmap): OCRResult {
        IRISLogger.runtime("OCR: Scanning text from bitmap...")
        // Placeholder for ML Kit Text Recognition
        
        // Mocking OCR result
        val mockedElements = listOf(
            TextElement("Quest Complete", Rect(100, 100, 300, 150), 0.99f),
            TextElement("Daily Reward", Rect(100, 200, 300, 250), 0.95f),
            TextElement("Claim", Rect(400, 500, 500, 550), 0.98f)
        )
        
        return OCRResult(
            fullText = mockedElements.joinToString(" ") { it.text },
            elements = mockedElements
        )
    }

    fun findText(result: OCRResult, query: String): TextElement? {
        return result.elements.find { it.text.contains(query, ignoreCase = true) }
    }
}
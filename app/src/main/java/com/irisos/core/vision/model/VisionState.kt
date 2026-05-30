package com.irisos.core.vision.model

import com.irisos.core.vision.detector.DetectionBox
import com.irisos.core.vision.ocr.OCRResult

data class VisionState(
    val lastOcrResult: OCRResult? = null,
    val lastDetections: List<DetectionBox> = emptyList(),
    val isAnalyzing: Boolean = false,
    val error: String? = null
)
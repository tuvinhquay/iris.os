package com.irisos.core.vision.capture

import android.graphics.Bitmap

data class CaptureResult(
    val bitmap: Bitmap?,
    val timestamp: Long = System.currentTimeMillis(),
    val isSuccess: Boolean = bitmap != null,
    val errorMessage: String? = null
)
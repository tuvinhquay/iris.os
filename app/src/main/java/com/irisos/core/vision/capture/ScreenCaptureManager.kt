package com.irisos.core.vision.capture

import android.graphics.Bitmap
import android.graphics.Matrix
import com.irisos.core.logs.IRISLogger

object ScreenCaptureManager {
    private var lastFrame: Bitmap? = null

    fun captureScreen(): CaptureResult {
        IRISLogger.runtime("Vision: Capturing screen...")
        // Placeholder for MediaProjection or Accessibility screenshot logic
        // For now, return a mock result
        return CaptureResult(bitmap = lastFrame)
    }

    fun resizeBitmap(source: Bitmap, maxWidth: Int, maxHeight: Int): Bitmap {
        val width = source.width
        val height = source.height
        val scale = Math.min(maxWidth.toFloat() / width, maxHeight.toFloat() / height)
        
        val matrix = Matrix()
        matrix.postScale(scale, scale)
        
        return Bitmap.createBitmap(source, 0, 0, width, height, matrix, true)
    }

    fun cacheFrame(bitmap: Bitmap) {
        lastFrame?.recycle()
        lastFrame = bitmap
    }
}
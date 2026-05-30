package com.irisos.core.vision.overlay

import android.content.Context
import android.graphics.*
import android.view.View
import com.irisos.core.logs.IRISLogger

class VisionOverlay(context: Context) : View(context) {
    private var state = OverlayState()
    private val paintBox = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }
    private val paintText = Paint().apply {
        color = Color.GREEN
        textSize = 30f
        typeface = Typeface.DEFAULT_BOLD
    }

    fun updateState(newState: OverlayState) {
        this.state = newState
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (!state.isVisible) return

        // Draw detected UI boxes
        state.detectedBoxes.forEach { box ->
            canvas.drawRect(box.bounds, paintBox)
            canvas.drawText(box.label, box.bounds.left.toFloat(), box.bounds.top.toFloat() - 10f, paintText)
        }

        // Draw OCR text elements
        state.detectedText.forEach { element ->
            canvas.drawRect(element.bounds, paintBox)
            canvas.drawText(element.text, element.bounds.left.toFloat(), element.bounds.bottom.toFloat() + 30f, paintText)
        }

        // Draw FPS
        canvas.drawText("FPS: ${state.fps}", 50f, 100f, paintText)
    }

    fun show() {
        IRISLogger.runtime("Overlay: Showing debug overlay")
        // Logic to add view to WindowManager
    }

    fun hide() {
        IRISLogger.runtime("Overlay: Hiding debug overlay")
    }
}
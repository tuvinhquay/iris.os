package com.irisos.core.automation

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent
import com.irisos.core.logs.IRISLogger

class IRISAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Read active window or notifications
    }

    override fun onInterrupt() {
        IRISLogger.w("Accessibility Service Interrupted")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        IRISLogger.runtime("Accessibility Service Connected")
        ActionEngine.setService(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActionEngine.setService(null)
    }

    fun performTap(x: Int, y: Int) {
        val path = Path()
        path.moveTo(x.toFloat(), y.toFloat())
        val gestureBuilder = GestureDescription.Builder()
        gestureBuilder.addStroke(GestureDescription.StrokeDescription(path, 0, 100))
        dispatchGesture(gestureBuilder.build(), null, null)
        IRISLogger.automation("Accessibility: Tapping at ($x, $y)")
    }

    fun performSwipe(x1: Int, y1: Int, x2: Int, y2: Int, duration: Long) {
        val path = Path()
        path.moveTo(x1.toFloat(), y1.toFloat())
        path.lineTo(x2.toFloat(), y2.toFloat())
        val gestureBuilder = GestureDescription.Builder()
        gestureBuilder.addStroke(GestureDescription.StrokeDescription(path, 0, duration))
        dispatchGesture(gestureBuilder.build(), null, null)
        IRISLogger.automation("Accessibility: Swiping from ($x1, $y1) to ($x2, $y2)")
    }
}
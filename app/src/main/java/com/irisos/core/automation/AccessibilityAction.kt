package com.irisos.core.automation

sealed class AccessibilityAction {
    data class Tap(val x: Int, val y: Int) : AccessibilityAction()
    data class Swipe(val x1: Int, val y1: Int, val x2: Int, val y2: Int, val duration: Long) : AccessibilityAction()
    data class ClickNode(val text: String) : AccessibilityAction()
    object Back : AccessibilityAction()
    object Home : AccessibilityAction()
}
package com.irisos.core.automation

import com.irisos.core.logs.IRISLogger
import com.irisos.core.ai.TaskAction
import com.irisos.core.ai.ActionType

object ActionEngine {
    private var accessibilityService: IRISAccessibilityService? = null

    fun setService(service: IRISAccessibilityService?) {
        this.accessibilityService = service
    }

    fun executeAction(action: TaskAction) {
        IRISLogger.automation("ActionEngine: Executing ${action.type} - ${action.targetLabel ?: ""}")
        
        // Record action for anti-loop system
        AntiLoopManager.recordAction(action.type)
        
        when (action.type) {
            ActionType.TAP, ActionType.CLAIM_REWARD, ActionType.OPEN_QUEST, ActionType.CLOSE_POPUP -> {
                if (action.x != null && action.y != null) {
                    accessibilityService?.performTap(action.x, action.y)
                } else {
                    IRISLogger.w("ActionEngine: Missing coordinates for ${action.type}")
                }
            }
            ActionType.SWIPE -> {
                if (action.x != null && action.y != null && action.x2 != null && action.y2 != null) {
                    accessibilityService?.performSwipe(action.x, action.y, action.x2, action.y2, action.duration)
                } else {
                    IRISLogger.w("ActionEngine: Missing coordinates for SWIPE")
                }
            }
            ActionType.WAIT -> {
                IRISLogger.automation("ActionEngine: Waiting for ${action.duration}ms")
            }
            ActionType.NONE -> {
                IRISLogger.automation("ActionEngine: No action required")
            }
            else -> {
                IRISLogger.w("ActionEngine: Unsupported action type ${action.type}")
            }
        }
    }
}
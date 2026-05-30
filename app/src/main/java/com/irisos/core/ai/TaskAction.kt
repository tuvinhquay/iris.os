package com.irisos.core.ai

enum class ActionType {
    TAP,
    SWIPE,
    WAIT,
    SCROLL,
    LONG_PRESS,
    CLAIM_REWARD,
    OPEN_QUEST,
    CLOSE_POPUP,
    GOTO_MAIN_MENU,
    NONE
}

data class TaskAction(
    val type: ActionType,
    val targetLabel: String? = null,
    val x: Int? = null,
    val y: Int? = null,
    val x2: Int? = null,
    val y2: Int? = null,
    val duration: Long = 500,
    val priority: Int = 0
)
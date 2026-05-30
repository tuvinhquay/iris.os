package com.irisos.core.automation

enum class TaskState {
    IDLE,
    QUEUED,
    RUNNING,
    COMPLETED,
    FAILED,
    CANCELLED
}
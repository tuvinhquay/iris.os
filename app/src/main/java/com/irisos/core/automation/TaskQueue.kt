package com.irisos.core.automation

import com.irisos.core.logs.IRISLogger
import java.util.LinkedList

object TaskQueue {
    private val queue = LinkedList<String>()

    fun addTask(taskId: String) {
        IRISLogger.automation("Adding task to queue: $taskId")
        queue.add(taskId)
    }

    fun pollTask(): String? {
        return queue.poll()
    }

    fun isEmpty() = queue.isEmpty()
}
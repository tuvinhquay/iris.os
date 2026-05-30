package com.irisos.core.logs

import android.util.Log

object IRISLogger {
    private const val TAG = "IRIS_OS"

    fun i(message: String) {
        Log.i(TAG, "[INFO] $message")
    }

    fun w(message: String) {
        Log.w(TAG, "[WARN] $message")
    }

    fun e(message: String, throwable: Throwable? = null) {
        Log.e(TAG, "[ERROR] $message", throwable)
    }

    fun runtime(message: String) {
        Log.d(TAG, "[RUNTIME] $message")
    }

    fun ai(message: String) {
        Log.d(TAG, "[AI] $message")
    }

    fun automation(message: String) {
        Log.d(TAG, "[AUTO] $message")
    }
}
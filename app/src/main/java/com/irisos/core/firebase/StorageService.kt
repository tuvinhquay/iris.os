package com.irisos.core.firebase

import com.irisos.core.logs.IRISLogger

object StorageService {
    fun uploadFile(path: String, bytes: ByteArray) {
        IRISLogger.runtime("Firebase Storage: Uploading file to $path")
        // Placeholder for FirebaseStorage.getInstance()...
    }
}
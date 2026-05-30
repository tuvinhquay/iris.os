package com.irisos.core.firebase

import com.irisos.core.logs.IRISLogger

object FirestoreService {
    fun saveData(collection: String, document: String, data: Map<String, Any>) {
        IRISLogger.runtime("Firestore: Saving data to $collection/$document")
        // Placeholder for FirebaseFirestore.getInstance()...
    }

    fun getData(collection: String, document: String) {
        IRISLogger.runtime("Firestore: Getting data from $collection/$document")
    }
}
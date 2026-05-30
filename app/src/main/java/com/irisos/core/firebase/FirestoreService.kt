package com.irisos.core.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.irisos.core.logs.IRISLogger
import java.util.*

object FirestoreService {
    private val db by lazy { FirebaseFirestore.getInstance() }
    private const val DEVICE_ID = "device_001" // Sau này có thể dùng ID thực tế của máy

    fun syncRuntimeStatus(state: String, lastAction: String, isStuck: Boolean) {
        val status = hashMapOf(
            "state" to state,
            "lastAction" to lastAction,
            "isStuck" to isStuck,
            "timestamp" to Date(),
            "lastSeen" to System.currentTimeMillis()
        )

        db.collection("bots").document(DEVICE_ID)
            .set(status, SetOptions.merge())
            .addOnFailureListener { e ->
                IRISLogger.runtime("Firestore Sync Error: ${e.message}")
            }
    }

    fun logEvent(tag: String, message: String) {
        val event = hashMapOf(
            "tag" to tag,
            "message" to message,
            "timestamp" to Date()
        )

        db.collection("bots").document(DEVICE_ID)
            .collection("logs")
            .add(event)
    }
}
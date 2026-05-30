#!/bin/bash
# IRIS OS - Runtime State Checker
echo "[CI-MINI] Checking Game State Engine..."
if [ -f "app/src/main/java/com/irisos/core/engine/GameStateManager.kt" ]; then
    echo "✅ GameStateManager found."
else
    echo "❌ GameStateManager missing."
fi
echo "[CI-MINI] Runtime state check finished."

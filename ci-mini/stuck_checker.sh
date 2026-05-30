#!/bin/bash
# IRIS OS - Anti-Stuck Checker
echo "[CI-MINI] Checking Anti-Stuck System..."
if [ -f "app/src/main/java/com/irisos/core/automation/AntiStuckManager.kt" ]; then
    echo "✅ AntiStuckManager found."
else
    echo "❌ AntiStuckManager missing."
fi
echo "[CI-MINI] Anti-stuck check finished."

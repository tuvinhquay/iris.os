#!/bin/bash
# IRIS OS - Action Engine Checker
echo "[CI-MINI] Checking Action Engine..."
if [ -f "app/src/main/java/com/irisos/core/automation/ActionEngine.kt" ]; then
    echo "✅ ActionEngine found."
else
    echo "❌ ActionEngine missing."
fi
echo "[CI-MINI] Action engine check finished."

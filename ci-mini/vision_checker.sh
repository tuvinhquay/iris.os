#!/bin/bash
# IRIS OS - Vision Checker
echo "[CI-MINI] Checking Vision Engine..."
if [ -f "app/src/main/java/com/irisos/core/vision/capture/ScreenCaptureManager.kt" ]; then
    echo "✅ ScreenCaptureManager found."
else
    echo "❌ ScreenCaptureManager missing."
fi
echo "[CI-MINI] Vision check finished."

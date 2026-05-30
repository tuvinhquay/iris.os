#!/bin/bash
# IRIS OS - AI Checker
echo "[CI-MINI] Checking AI Foundation..."
# Check for AI provider implementation
if [ -f "app/src/main/java/com/irisos/core/ai/GeminiProvider.kt" ]; then
    echo "✅ AI Provider found."
else
    echo "❌ AI Provider missing."
fi
echo "[CI-MINI] AI check finished."

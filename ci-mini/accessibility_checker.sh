#!/bin/bash
# IRIS OS - Accessibility Checker
echo "[CI-MINI] Checking Accessibility Foundation..."
if [ -f "app/src/main/java/com/irisos/core/automation/IRISAccessibilityService.kt" ]; then
    echo "✅ IRISAccessibilityService found."
else
    echo "❌ IRISAccessibilityService missing."
fi
# Check if registered in manifest (simplified check)
grep -q "IRISAccessibilityService" app/src/main/AndroidManifest.xml
if [ $? -eq 0 ]; then
    echo "✅ Service registered in Manifest."
else
    echo "⚠️ Service NOT registered in Manifest."
fi
echo "[CI-MINI] Accessibility check finished."

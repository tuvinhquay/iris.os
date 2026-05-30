#!/bin/bash
# IRIS OS - OCR Checker
echo "[CI-MINI] Checking OCR Foundation..."
if [ -f "app/src/main/java/com/irisos/core/vision/ocr/OCRManager.kt" ]; then
    echo "✅ OCRManager found."
else
    echo "❌ OCRManager missing."
fi
# Check for ML Kit dependency in build.gradle
grep -q "mlkit-text-recognition" app/build.gradle.kts
if [ $? -eq 0 ]; then
    echo "✅ ML Kit OCR dependency found."
else
    echo "❌ ML Kit OCR dependency missing in build.gradle.kts"
fi
echo "[CI-MINI] OCR check finished."

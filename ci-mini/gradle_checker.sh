#!/bin/bash
# IRIS OS - Gradle Checker
echo "[CI-MINI] Checking Gradle build status..."
./gradlew --version
if [ $? -eq 0 ]; then
    echo "✅ Gradle is functional."
else
    echo "❌ Gradle check failed."
fi
echo "[CI-MINI] Gradle check finished."

#!/bin/bash
# IRIS OS - Architecture Checker
echo "[CI-MINI] Checking Package Architecture..."
packages=("ai" "automation" "data" "domain" "ui" "memory" "firebase" "engine" "logs" "utils")
missing=0

for pkg in "${packages[@]}"; do
    if [ -d "app/src/main/java/com/irisos/core/$pkg" ]; then
        echo "✅ Package $pkg found."
    else
        echo "❌ Package $pkg missing."
        missing=$((missing+1))
    fi
done

if [ $missing -eq 0 ]; then
    echo "✅ Architecture is correct."
else
    echo "❌ Architecture check failed with $missing missing packages."
fi

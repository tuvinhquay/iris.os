#!/bin/bash
# IRIS OS - Memory Checker
echo "[CI-MINI] Checking JSON Memory files..."
files=("memory/player_memory.json" "memory/task_history.json" "memory/game_strategy.json")
missing=0

for file in "${files[@]}"; do
    if [ -f "$file" ]; then
        echo "✅ $file exists."
    else
        echo "❌ $file missing."
        missing=$((missing+1))
    fi
done

if [ $missing -eq 0 ]; then
    echo "✅ Memory system structure is OK."
else
    echo "❌ Memory system check failed."
fi

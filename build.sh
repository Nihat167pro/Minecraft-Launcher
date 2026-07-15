#!/bin/bash
# REALS Minecraft Launcher - Linux/macOS Build Script
# Azərbaycanca Minecraft Launcher - Real Versiyası

echo ""
echo "========================================"
echo "REALS Minecraft Launcher - JAR Builder"
echo "========================================"
echo ""

# Maven yüklənib-yüklənmədiyi yoxla
if ! command -v mvn &> /dev/null; then
    echo "ERROR: Maven quraşdırılmayıb!"
    echo "Lütfən Maven-i yükləyin:"
    echo "  macOS: brew install maven"
    echo "  Linux: sudo apt install maven"
    echo ""
    exit 1
fi

echo "[1/2] Launcher JAR faylı yaradılır..."
mvn clean package -DskipTests -q
if [ $? -ne 0 ]; then
    echo "ERROR: JAR yaradılması başarısız oldu!"
    exit 1
fi

echo "[2/2] JAR faylı hazırlanır..."
if [ -f "target/reals-launcher-1.0.jar" ]; then
    echo ""
    echo "========================================"
    echo "BAŞARILI! reals-launcher-1.0.jar hazırdır"
    echo "========================================"
    echo ""
    echo "Başlatmaq üçün:"
    echo "  java -jar target/reals-launcher-1.0.jar"
    echo ""
else
    echo "ERROR: JAR faylı yaradılmadı!"
    exit 1
fi

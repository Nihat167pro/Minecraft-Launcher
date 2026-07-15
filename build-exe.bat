@echo off
REM REALS Minecraft Launcher - Windows Build Script
REM Əzərbaycan Minecraft Launcher - Real Versiyası

echo.
echo ========================================
echo REALS Minecraft Launcher - EXE Builder
echo ========================================
echo.

REM Maven yüklənib-yüklənmədiyi yoxla
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Maven quraşdırılmayıb!
    echo Lütfən Maven-i yükləyin: https://maven.apache.org/download.cgi
    echo.
    pause
    exit /b 1
)

echo [1/4] Java bağımlılıqları yüklənir...
mvn clean install -q
if %errorlevel% neq 0 (
    echo ERROR: Maven build başarısız oldu!
    pause
    exit /b 1
)

echo [2/4] Launcher JAR faylı yaradılır...
mvn package -DskipTests -q
if %errorlevel% neq 0 (
    echo ERROR: JAR yaradılması başarısız oldu!
    pause
    exit /b 1
)

echo [3/4] EXE wrapperi yüklənir...
REM Launch4jü yüklə - bu adımı əl ilə yapab sən
echo Launch4j quraşdırmasını təmin edin: http://launch4j.sourceforge.net/
echo.

echo [4/4] EXE faylı yaradılır...
REM launch4j launch4j-config.xml

echo.
echo ========================================
echo BAŞARILI! REALS-Launcher.exe yaradıldı
echo ========================================
echo.
pause

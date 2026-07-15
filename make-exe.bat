@echo off
REM EXE faylı yaratma - Tez metod
echo REALS Minecraft Launcher - EXE Build
echo.
echo Step 1: Maven clean install
mvn clean install -DskipTests
echo.
echo Step 2: Create JAR
mvn package -DskipTests
echo.
echo Step 3: JAR -> EXE with Launch4j
echo Please install Launch4j: http://launch4j.sourceforge.net/
echo Then run: launch4j launch4j-config.xml
echo.
echo DONE! REALS-Launcher.exe ready.
pause

; REALS Launcher - NSIS Installer Script
; Azərbaycanca Minecraft Launcher - Real Versiyası
; Windows Installer Builder

!include "MUI2.nsh"
!include "x64.nsh"

; Setup
Name "REALS Minecraft Launcher v1.0.0"
OutFile "REALS-Launcher-Setup-v1.0.0.exe"
InstallDir "$PROGRAMFILES64\REALS Launcher"
InstallDirRegKey HKLM "Software\REALS Launcher" "Install_Dir"

; MUI Settings
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

!insertmacro MUI_LANGUAGE "Turkish"
!insertmacro MUI_LANGUAGE "English"

; Installer
Section "Quraşdırma"
  SetOutPath "$INSTDIR"
  
  ; Faylları kopyala
  File "REALS-Launcher.exe"
  File "target/reals-launcher-1.0.jar"
  File "README.md"
  File "LICENSE"
  
  ; Shortcuts
  CreateDirectory "$SMPROGRAMS\REALS Launcher"
  CreateShortCut "$SMPROGRAMS\REALS Launcher\REALS Launcher.lnk" "$INSTDIR\REALS-Launcher.exe"
  CreateShortCut "$SMPROGRAMS\REALS Launcher\Uninstall.lnk" "$INSTDIR\uninstall.exe"
  CreateShortCut "$DESKTOP\REALS Launcher.lnk" "$INSTDIR\REALS-Launcher.exe"
  
  ; Registry
  WriteRegStr HKLM "Software\REALS Launcher" "Install_Dir" "$INSTDIR"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\REALS Launcher" "DisplayName" "REALS Minecraft Launcher v1.0.0"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\REALS Launcher" "UninstallString" "$INSTDIR\uninstall.exe"
  
  ; Uninstaller
  WriteUninstaller "$INSTDIR\uninstall.exe"
SectionEnd

; Uninstaller
Section "Uninstall"
  RMDir /r "$SMPROGRAMS\REALS Launcher"
  RMDir /r "$INSTDIR"
  DeleteRegKey HKLM "Software\REALS Launcher"
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\REALS Launcher"
SectionEnd

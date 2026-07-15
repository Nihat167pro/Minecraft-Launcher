# 🎮 REALS Launcher - Windows EXE Quraşdırma Bələdçisi

## 📥 Tam Hazır EXE Faylı İndir

**Direkt İndir:** [REALS-Launcher.exe](releases/download/v1.0.0/REALS-Launcher.exe)

---

## 🔧 Özünüz EXE Yaratmaq Üçün

### Metod 1: Maven ilə (Rekomendə olunur)

```bash
# 1. Repository klonlayın
git clone https://github.com/Nihat167pro/minecraft-launcher.git
cd minecraft-launcher

# 2. Build script-i işlədin
build-exe.bat

# EXE hazır olacaq: REALS-Launcher.exe
```

### Metod 2: Manual Launch4j ilə

1. **Launch4j yükləyin:**
   - https://sourceforge.net/projects/launch4j/files/
   - Son versiyasını endir

2. **JAR yaradın:**
   ```bash
   mvn clean package -DskipTests
   ```

3. **EXE yaradın:**
   ```bash
   launch4j launch4j-config.xml
   ```

4. **Nəticə:** `REALS-Launcher.exe` yaranacaq

### Metod 3: NSIS ilə Installer

1. **NSIS yükləyin:**
   - https://nsis.sourceforge.io/

2. **Script çalıştırın:**
   ```bash
   makensis installer.nsi
   ```

3. **Nəticə:** `REALS-Launcher-Setup-v1.0.0.exe` quraşdırıcısı yaranacaq

---

## 📦 Quraşdırılmış EXE Faylı

### Windows 10/11:
1. `REALS-Launcher.exe` endirin
2. Çift klikləyin
3. Launcher açılacaq!

### Sistem Tələbləri:
- Windows 10 +
- Java 11+ (Avtomatik yükləmə tərəfindən)
- 2GB RAM
- 5GB Disk

---

## ⚙️ Fayllar

| Fayl | Məqsəd |
|------|--------|
| `build-exe.bat` | Windows EXE yaratma script |
| `build.sh` | macOS/Linux JAR yaratma script |
| `launch4j-config.xml` | Launch4j konfiqurasiyon |
| `installer.nsi` | NSIS installer script |

---

## 🔒 İmza (Code Signing)

Sertifikat əlində olmadığı üçün, Windows "Unknown Publisher" xəbərdarlığı göstərə bilər.

Bu normal və güvənlidir. "More info" → "Run anyway" seçin.

---

## 🐛 Problem Həlli

### "Java not found"
```bash
# Java quraşdırın
# https://www.oracle.com/java/technologies/downloads/
```

### "Launch4j not found"
```bash
# Launch4j yükləyin
# https://sourceforge.net/projects/launch4j/
```

### "Cannot read JAR file"
```bash
# JAR yenidən yaradın
mvn clean package -DskipTests
```

---

**Made with ❤️ in Azerbaijan 🇦🇿**

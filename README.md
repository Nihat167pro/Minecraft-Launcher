# 🎮 REALS Minecraft Launcher

**Azərbaycan Minecraft Launcher - Real Versiyası**

## ✨ Özəlliklər

✅ **Minecraft Əsas Versiyalar**
- 1.8.9 (PvP)
- 1.12.2 (Modlar)
- 1.16.5 (Hybrid)
- 1.19.2 (Yeni)
- 1.20.1 (Ən Yeni)

✅ **Account Management**
- Microsoft Account Dəstəyi
- Oflayn Account
- Çoxlu Account Saxlama
- Token Refresh

✅ **Game Settings**
- RAM Ayarları (512MB - 16GB)
- JVM Arqumentləri
- Game Resolution
- Vsync/FPS Limitər

✅ **Mod Management**
- Forge/Fabric Dəstəyi
- Mod Yüklə/Sil
- Mod Konflikt Yoxla
- ModPack İmport

✅ **Performance**
- Sürətli Başlantı
- Asset Cache
- Parallel Download
- Auto Optimize

## 📋 Sistem Tələbləri

- **OS**: Windows 10+ / macOS 10.12+ / Linux
- **Java**: Java 8+
- **RAM**: Minimum 2GB
- **Storage**: 5GB+

## 🚀 Quraşdırma

```bash
# Layihəni klonlayın
git clone https://github.com/Nihat167pro/minecraft-launcher.git
cd minecraft-launcher

# Maven ilə quraşdırın
mvn clean package

# Başlayın
java -jar target/reals-launcher-1.0.jar
```

## 🛠️ Layihə Strukturu

```
minecraft-launcher/
├── src/
│   ├── main/java/com/reals/launcher/
│   │   ├── Main.java
│   │   ├── ui/
│   │   │   ├── LauncherUI.java
│   │   │   ├── panels/
│   │   │   │   ├── HomePanel.java
│   │   │   │   ├── SettingsPanel.java
│   │   │   │   ├── ModsPanel.java
│   │   │   │   └── AccountsPanel.java
│   │   ├── core/
│   │   │   ├── GameLauncher.java
│   │   │   ├── VersionManager.java
│   │   │   ├── AccountManager.java
│   │   │   └── ModManager.java
│   │   ├── net/
│   │   │   ├── Downloader.java
│   │   │   ├── MicrosoftAuth.java
│   │   │   └── LauncherMeta.java
│   │   └── utils/
│   │       ├── FileUtils.java
│   │       ├── SystemUtils.java
│   │       └── ConfigManager.java
│   └── resources/
│       ├── config/
│       ├── assets/
│       └── themes/
├── pom.xml
└── README.md
```

## 📝 Config Faylı (~/.reals-launcher/config.json)

```json
{
  "version": "1.0",
  "selectedVersion": "1.20.1",
  "ramMin": 512,
  "ramMax": 4096,
  "gameResolution": "1920x1080",
  "javaPath": "/usr/lib/jvm/java-17",
  "accounts": [],
  "mods": [],
  "autoUpdate": true,
  "language": "az"
}
```

## 🎨 UI Tema

- **Dark Mode**: Qaranlıq Mavi Tema
- **Colors**:
  - Primary: #1E90FF (Mavi)
  - Secondary: #00CED1 (Firuzə)
  - Danger: #FF6347 (Qırmızı)
  - Success: #32CD32 (Yaşıl)

## 🔐 Güvənlik

- Microsoft OAuth 2.0
- Local Token Storage
- Secure Session Management
- Anti-Virus Uyumlu

## 🐛 Bug Report / Xüsusiyyət İstəyi

Lütfən [Issues](https://github.com/Nihat167pro/minecraft-launcher/issues) səhifəsində yaradın.

## 📜 Lisenziya

MIT License - Sərbəst istifadə edin!

## 👤 Müəllif

**Nihat167pro** - [@Nihat167pro](https://github.com/Nihat167pro)

---

**Made with ❤️ in Azerbaijan 🇦🇿**
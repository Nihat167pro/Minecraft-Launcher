# 🤝 REALS Launcher'a Töhfə Vermə Bələdçisi

## Xoş Gəldiniz! 👋

REALS Minecraft Launcher'a töhfə vermə istəyi üçün təşəkkür edirik!

---

## 📋 Başlamadan Əvvəl

1. **GitHub Hesabı yaradın** (əgər yoxdursa)
2. **Bu depoyu Fork edin**
3. **Kompüterinizə klonlayın**

```bash
git clone https://github.com/YOUR_USERNAME/minecraft-launcher.git
cd minecraft-launcher
```

---

## 🔄 İş Axını (Workflow)

### 1. Yeni Branch Yaradın

```bash
# Əsas branc-dən yenisini yaradın
git checkout -b feature/your-feature-name

# Məsələn:
git checkout -b feature/microsoft-oauth-integration
git checkout -b bugfix/launcher-crash
```

### 2. Dəyişiklik Edin

- Kodunuzu yazın
- Test edin
- Commit edin

```bash
git add .
git commit -m "Fix: Launcher crash issue #123"
# ya da
git commit -m "Feature: Add Microsoft OAuth support"
```

### 3. Push edin

```bash
git push origin feature/your-feature-name
```

### 4. Pull Request Açın

1. GitHub-da deponuza keçin
2. "Compare & pull request" düyməsinə klikləyin
3. Şablondan istifadə edərək PR təsviri yazın
4. Gözləyin ki, maintainer'lar review etsinlər

---

## 📝 Commit Mesajları

**Aşağıdakı formatı istifadə edin:**

```
<type>: <subject>

<body>

<footer>
```

### Tipləri:
- **feat**: Yeni xüsusiyyət
- **fix**: Bug düzəltmə
- **docs**: Dokumentasiya
- **style**: Kod stilində dəyişiklik (format, semicolon, vb.)
- **refactor**: Kod yenidən yazma
- **perf**: Performance yaxşılaşdırma
- **test**: Test əlavə/düzəltmə
- **chore**: Build, npm, vb. dəyişikliklər

### Nümunələr:

```
feat: Add Microsoft OAuth authentication

Implements Microsoft OAuth 2.0 flow for account authentication.
- Added MicrosoftAuth.java class
- Integrated with AccountManager
- Added error handling

Closes #42
```

```
fix: Fix launcher crash on startup

Resolves NullPointerException when loading config file.
- Added null check in ConfigManager
- Added default config generation

Closes #15
```

---

## 🧪 Teslim Əvvəl Yoxlama

```bash
# Layihəni quraşdırın
mvn clean package

# Testləri işlədin
mvn test

# Code style yoxlayın
mvn checkstyle:check
```

---

## 📚 Kodlaşdırma Standartları

### Java Qonvensiyas

```java
// Sınıf adları CamelCase
public class GameLauncher { }

// Metod adları camelCase
public void launchGame() { }

// Sabitlər UPPER_SNAKE_CASE
private static final String LAUNCHER_VERSION = "1.0.0";

// Variabllar camelCase
private String configPath;
```

### JavaDoc Şərhlər

```java
/**
 * Oyunu başlatıcı
 * 
 * @param version Minecraft versiyası (məs. "1.20.1")
 * @param account Hesab adı
 * @param ram RAM məbləğində MB
 * @throws IOException Oyun faylı yükləniməsə
 */
public void launch(String version, String account, int ram) throws IOException {
    // İmplementasiya
}
```

---

## 🐛 Bug Report Etmə

### Bug tapşırdığınızda:

1. **Açıq bir Issue arayın** - Artıq bildiriləndir mi?
2. **Yeni Issue açın**
3. **Aşağıdakıları yazın:**

```markdown
## 🐛 Bug Təsviri
[Nə baş gəlir?]

## 📋 Addımlar (Əvvəlcə Yenidən Yaratmaq)
1. ...
2. ...
3. ...

## ✅ Gözlənilən Davranış
[Nə olmalı?]

## ❌ Faktiki Davranış
[Nə baş gəlir?]

## 🖥️ Sistem Məlumatı
- OS: Windows 10 / macOS / Linux
- Java Versiyas: 11 / 17 / 21
- Launcher Versiyas: 1.0.0

## 📎 Əlavə
[Screenshot, logs, vb.]
```

---

## 💡 Xüsusiyyət Təklif Etmə

### Yeni xüsusiyyət istəyini yaşıldıqda:

```markdown
## 🎯 Xüsusiyyət Təsviri
[Nə etməlidir?]

## 🤔 Problem
[Hansı problemi həll edir?]

## 💻 Həll
[Necə həll edə biləriz?]

## 📋 Alternatif Həllər
[Başqa seçənəklər?]

## 📸 Kontekst
[Screenshot, nümunə, vb.]
```

---

## 🔍 Code Review Prosesi

1. **PR açıldıqdan sonra**, reviewers kod yoxlayacaqlar
2. **Şərhlər ala bilərsiniz** - Pozitiv rəhbərlikdir!
3. **Dəyişikliklər edin** - Əgər tənqid alsanız
4. **Push edin** - Eyni branchə
5. **Təsdiq alın** - 2+ reviewer-dən
6. **Merge olun** - Maintainer tərəfindən

---

## 🎓 Əlavə Resurslar

- [GitHub Dokumentasiyası](https://docs.github.com)
- [Git Tutorial](https://git-scm.com/book/en/v2)
- [Java Best Practices](https://www.oracle.com/java/technologies/javase/codeconventions-136091.html)
- [Maven Guide](https://maven.apache.org/guides/)

---

## ❓ Suallarınız Varsa

- 💬 [Discussions](https://github.com/Nihat167pro/minecraft-launcher/discussions) açın
- 📧 Email: tagizadetagizade300@gmail.com
- 🐛 [Issues](https://github.com/Nihat167pro/minecraft-launcher/issues)

---

**Əvvəlcədən Təşəkkürlər! Your contribution makes REALS better! 🚀**

**Made with ❤️ in Azerbaijan 🇦🇿**

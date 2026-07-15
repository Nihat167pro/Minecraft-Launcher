# 🔒 REALS Launcher - Təhlükəsizlik Siyasəti

## Təhlükəsizlik Məsələsini Bildirmə

**Cəmiyyətə Açıq Olmadan Əvvəl Əmsallaşdırılı Bildirimi Təmin Edin**

Eğər REALS Launcher-da təhlükəsizlik açığı (vulnerability) tapdığınızı düşünürsünsüz, zəhmət olmasa **GitHub Issue açmayın**.

Bunun əvəzinə:

1. **Email göndərin**: tagizadetagizade300@gmail.com
2. **Subject**: `[SECURITY] Vulnerability Report`
3. **Məlumatlar**:
   - Açığın açıklaması
   - Əvvəlcə yenidən yaratma addımları
   - Təsirinə dair məlumat
   - Təklif olunan həll (əgər varsa)

---

## Cavab Müddəti

- 🚨 **Kritik**: 24 saat içində
- 🔴 **Yüksək**: 48 saat içində
- 🟠 **Orta**: 1 həftə içində
- 🟡 **Aşağı**: 2 həftə içində

---

## Təhlükəsizlik Xətləri

### Kəsin Keçmə (Pass)
- ✅ Yeni xüsusiyyətləri test etmə
- ✅ Dokumentasyon üzərində iş
- ✅ Performans yaxşılaşdırması

### Qırmızı Xətlər (Red Lines)
- ❌ Şifrələri hardcode-da saxlamaq
- ❌ Sensitive məlumatı log-da saxlamaq
- ❌ SQL Injection açığı
- ❌ Cross-Site Scripting (XSS)
- ❌ Path Traversal
- ❌ Insecure Deserialization

---

## Təhlükəsizlik Yoxlamaları

### Hər PR-də Kontrol Edin:

```bash
# Dependency vulnerabilities
mvn dependency-check:check

# Static code analysis
mvn sonar:sonar

# Security audit
mvn security:check
```

---

## Encryption Best Practices

### Şifrə Saxlanması:

```java
// ❌ YANLIŞDIR
String password = "myPassword123";

// ✅ DOĞRULUR
char[] password = readPasswordFromSecureInput();
Arrays.fill(password, ' '); // Memory-dən silin
```

### Token Saxlanması:

```java
// ✅ DOĞRULUR - Platform keystore-da saxlayın
KeyStore keyStore = KeyStore.getInstance("PKCS12");
keyStore.load(inputStream, password.toCharArray());
```

---

## Network Təhlükəsizliyi

### HTTPS İstifadə Edin:

```java
// ✅ DOĞRULUR
HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
conn.setSSLSocketFactory(sslContext.getSocketFactory());

// ❌ YANLIŞDIR
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
```

---

## Versiya Dəstəyi

| Versiya | Dəstək Haqqında | Təhlükəsizlik Yenilənməsi |
|---------|----------|---------------------|
| 1.0.x   | ✅ Aktif | Bütün xətalar |
| 0.9.x   | ⚠️ LTS | Yalnız kritik |
| Köhnə    | ❌ Heç bir dəstək | - |

---

## Təşəkkürlər

Təhlükəsizlik problemi bildirən hər kəsə təşəkkür edirik. Uyğun olaraq, kredit verəcəyik.

---

**Made with ❤️ in Azerbaijan 🇦🇿**

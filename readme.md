# SmartLamp

> **Aplikasi Android berbasis Java untuk kontrol dan monitoring lampu pintar**

---

## 📘 Tentang Aplikasi

SmartLamp adalah aplikasi Android yang dikembangkan menggunakan Java di Android Studio. Aplikasi ini memungkinkan pengguna untuk mengatur dan memantau lampu pintar melalui antarmuka yang modern, simpel, dan interaktif.

---

## 📌 Fitur Utama

1. **Splashscreen**

   * Tampilan pembuka aplikasi yang elegan.

2. **Login**

   * Sistem autentikasi untuk pengguna.

3. **Home Fragment**

   * Menu utama yang berisi kontrol akses ke fitur-fitur utama.

4. **Monitor Fragment**

   * Monitoring status dan aktivitas lampu secara real-time.

5. **Profile Fragment**

   * Menampilkan dan mengatur profil pengguna.

---

## 🗂️ Struktur Proyek

```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/chaerul.biz.id.smartlamp/
│   ├── adapter/
│   │   └── MenuAdapter.java
│   ├── fragment/
│   │   ├── HomeFragment.java
│   │   ├── MonitorFragment.java
│   │   └── ProfileFragment.java
│   ├── model/
│   │   └── ModelMenu.java
│   ├── serve/
│   │   └── ApiService.java
│   ├── MainActivity.java
│   ├── SplashscreebActivity.java
│   └── ViewPagerActivity.java
```

---

## 🧑‍💻 Teknologi Digunakan

* **Java** (Bahasa pemrograman utama)
* **Android SDK**
* **ViewPager & Fragment**
* **Material UI Components**
* **Retrofit / HTTP API** *(jika digunakan)*

---

## 🔧 Cara Menjalankan

1. Clone repository ini:

```bash
[git clone https://github.com/chaerul-id/SmartLamp.git](https://github.com/chaerul24/smartlamp_esp_android)
```

2. Buka project di Android Studio
3. Jalankan di emulator atau perangkat Android minimal SDK 21

---


## 🤝 Kontribusi

Kamu bisa bantu kembangkan aplikasi ini! Fork project-nya, buat perubahan, dan kirim pull request. Atau cukup laporkan bug lewat Issues!

---

## 📄 Lisensi

Proyek ini menggunakan lisensi MIT. Bebas digunakan dan dimodifikasi sesuai kebutuhan.

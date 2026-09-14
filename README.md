# ☕ Pemrograman Berorientasi Objek (OOP) - Semester 3

Repositori ini adalah jurnal perjalanan dan tempat penyimpanan kode untuk mata kuliah Pemrograman Berorientasi Objek (OOP) di semester 3.Karena Laptop saya bakal mati kalo kesenggol dikit,maka saya harus selalu menyimpan kode saya secara online

## 🎯 Fokus Pembelajaran

Selama semester ini, basis kode di dalam repositori akan mencakup pilar-pilar inti OOP:

*   **Class, Object & Constructor:** Mendesain cetak biru entitas (seperti `BangunRuang` dan `BankAccount`) dan menginisialisasi objek ke dalam memori.
*   **Encapsulation (Pembungkusan):** Melindungi data internal menggunakan *access modifier* `private` serta membangun jembatan interaksi yang aman melalui metode *Getter* dan *Setter*.
*   **Inheritance (Pewarisan):** Mengoptimalkan penggunaan ulang kode (*code reusability*) dari *Superclass* ke *Subclass*.
*   **Polymorphism (Banyak Bentuk):** Mengontrol perilaku metode yang dinamis melalui teknik *Overloading* dan *Overriding*.

## 📂 Struktur Repositori

*   `/TugasMingguan` - Kumpulan latihan dasar mingguan (contoh: kalkulator bangun ruang, sistem deposit bank).
*   `/ProjekGabut` - Proyek mini yang menguji implementasi logika *looping* (`while-true`) dan *Error Handling*.
*   `/TugasAkhir` - Direktori utama untuk tugas final komprehensif di akhir semester.

## 🚀 Cara Menjalankan Program Lokal

1. Pastikan komputer sudah terinstal **Java Development Kit (JDK)** versi 11 atau lebih baru.
2. *Clone* repositori ini ke lokal komputermu:
   ```bash
   git clone [https://github.com/](https://github.com/)[username-kamu]/[nama-repo-kamu].git
```
3. Buka terminal/CMD dan masuk ke dalam folder letak file Java yang ingin dieksekusi:
   e.g.
```bash 
   cd Tugas_Mingguan/BankSystem
```
 * Lakukan kompilasi untuk mengubah kode sumber menjadi bytecode:
```bash
   javac BankAccountDemo.java
```
 * Jalankan program hasil kompilasi:
```bash 
   java BankAccountDemo
```

# Proyek Geometri OOP Java

Proyek ini adalah implementasi program berbasis konsol menggunakan bahasa Java yang memodelkan berbagai bentuk geometri (Bentuk umum, Bujur Sangkar, Lingkaran, dan Silinder). Program ini dilengkapi dengan menu interaktif untuk menambah bentuk ke dalam daftar dan menampilkan informasi mendetail terkait bentuk-bentuk tersebut (seperti warna, luas, dan volume).

## Penerapan Konsep Pemrograman Berorientasi Objek (OOP)

Kode ini dirancang untuk mendemonstrasikan tiga pilar utama Pemrograman Berorientasi Objek, yaitu:

### 1. Enkapsulasi (Encapsulation)
Enkapsulasi adalah pembatasan akses langsung ke properti suatu objek untuk melindungi integritas data, di mana akses atau modifikasi dilakukan melalui metode khusus (getter dan setter).
* **Implementasi pada kode:** Pada kelas `BujurSangkar`, `Lingkaran`, dan `Silinder`, atribut-atribut spesifik seperti `sisi`, `radius`, dan `tinggi` dideklarasikan menggunakan *access modifier* `private`.
* Untuk membaca atau mengubah nilai atribut tersebut dari luar kelas, disediakan metode `getSisi()`, `setSisi()`, `getRadius()`, `setRadius()`, `getTinggi()`, dan `setTinggi()`.

### 2. Pewarisan (Inheritance)
Pewarisan adalah mekanisme di mana sebuah kelas (subclass) mewarisi atribut dan metode dari kelas lain (superclass), sehingga memungkinkan penggunaan ulang kode (*code reusability*).
* **Implementasi pada kode:**
  * Kelas `BujurSangkar` dan `Lingkaran` mewarisi kelas `Bentuk` (menggunakan sintaks `extends Bentuk`). Keduanya secara otomatis memiliki atribut `warna` dan mewarisi metode terkait dari kelas `Bentuk`.
  * Kelas `Silinder` mewarisi kelas `Lingkaran` (`extends Lingkaran`), yang menunjukkan pewarisan bertingkat (*multilevel inheritance*). `Silinder` tidak hanya memiliki warna dan radius, tetapi juga atribut tambahannya sendiri yaitu `tinggi`.
  * Penggunaan sintaks `super(warna)` atau `super(radius, warna)` di dalam konstruktor kelas anak berfungsi untuk memanggil dan menginisialisasi atribut yang ada pada kelas induk.

### 3. Polimorfisme (Polymorphism)
Polimorfisme memungkinkan sebuah entitas (seperti metode atau objek) memiliki banyak bentuk. Dalam proyek ini, polimorfisme diimplementasikan melalui *Method Overriding* dan *Dynamic Method Dispatch*.
* **Implementasi pada kode:** 
  * **Overriding:** Metode `printInfo()` yang ada di kelas induk `Bentuk` ditimpa (*di-override*) pada masing-masing kelas anak (`BujurSangkar`, `Lingkaran`, `Silinder`) agar menampilkan detail yang spesifik (menampilkan luas atau volume), yang ditandai dengan anotasi `@Override`.
  * **Polymorphic Collection:** Pada kelas `Main`, digunakan `ArrayList<Bentuk>` yang berperan sebagai penampung tunggal untuk objek-objek dari berbagai kelas (`Bentuk`, `BujurSangkar`, `Lingkaran`, `Silinder`). Saat melakukan perulangan (`for (Bentuk b : daftarBentuk)`) dan mengeksekusi `b.printInfo()`, program secara otomatis akan memanggil metode `printInfo()` yang sesuai dengan bentuk asli objek tersebut saat diinstansiasi, bukan berdasarkan tipe deklarasi variabelnya.

## Struktur Berkas
* `Bentuk.java` - Kelas induk dasar dari semua bentuk geometri.
* `BujurSangkar.java` - Kelas turunan `Bentuk` untuk menghitung luas persegi.
* `Lingkaran.java` - Kelas turunan `Bentuk` untuk menghitung luas lingkaran.
* `Silinder.java` - Kelas turunan `Lingkaran` untuk menghitung volume silinder 3D.
* `Main.java` - Kelas utama yang memuat perulangan menu interaktif dengan `Scanner` dan penyimpanan objek dengan `ArrayList`.

## Cara Menjalankan Program
1. Buka terminal atau command prompt.
2. Arahkan ke direktori tempat berkas-berkas Java tersebut disimpan.
3. Kompilasi seluruh kode sumber dengan perintah:
   `javac *.java`
4. Eksekusi program utama dengan perintah:
   `java Main`
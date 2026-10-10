# Implementasi Konsep Pemrograman Berorientasi Objek (OOP) pada Sistem Rekening Bank

Modifikasi sistem rekening bank mendemonstrasikan penerapan tiga pilar utama OOP sebagai berikut:

### 1. Enkapsulasi (Encapsulation)
Enkapsulasi bertujuan untuk menyembunyikan status internal sebuah objek, sehingga interaksi atau perubahan data hanya dapat dilakukan melalui metode yang valid dan aman.
* **Implementasi:** Atribut `current_balance` pada `BankAccount` dan `interestRate` pada `SavingsAccount` dideklarasikan dengan tingkat akses `private`. Satu-satunya cara untuk mengubah atau mengakses saldo dari luar kelas adalah dengan menggunakan metode *getter* (`getCurrentBalance`) dan *setter* (`setCurrentBalance`). Di dalam metode setter tersebut telah dibekali sistem validasi (seperti pelemparan error `IllegalArgumentException` jika saldo yang dimasukkan bernilai negatif) untuk menjaga integritas data.

### 2. Pewarisan (Inheritance)
Pewarisan digunakan agar kelas baru (subclass) dapat mengambil atribut dan fungsionalitas dari kelas yang sudah ada (superclass), sehingga mencegah duplikasi kode.
* **Implementasi:** Dibuat kelas baru bernama `SavingsAccount` yang mewarisi kelas `BankAccount` (ditandai dengan sintaks `extends BankAccount`). Dengan demikian, `SavingsAccount` secara otomatis memiliki kemampuan untuk melakukan `deposito()` dan `withdraw()` tanpa harus menulis ulang logika operasional tersebut dari nol. Pemanggilan `super(initial_balance)` juga digunakan pada konstruktor `SavingsAccount` untuk memanggil dan memicu konstruktor kelas induknya saat objek turunan dibuat.

### 3. Polimorfisme (Polymorphism)
Polimorfisme memungkinkan objek dari kelas turunan dapat diperlakukan sebagai bentuk yang sama dari kelas induknya, namun memberikan perilaku atau keluaran yang spesifik sesuai dengan wujud asli objek tersebut.
* **Implementasi:** 
  * **Method Overriding:** Metode `printInfo()` yang didefinisikan pada kelas `BankAccount` ditimpa ulang (menggunakan anotasi `@Override`) pada kelas `SavingsAccount` agar dapat menampilkan informasi yang lebih spesifik (yaitu dengan menambahkan informasi rasio bunga).
  * **Polymorphic Collection & Dynamic Method Dispatch:** Di dalam program utama, sebuah `ArrayList<BankAccount>` digunakan untuk menampung berbagai macam tipe akun, baik itu objek `BankAccount` (induk) maupun `SavingsAccount` (anak). Pada saat program melakukan iterasi dan memanggil fungsi `printInfo()` pada setiap elemen di dalam *list*, Java secara dinamis akan mengeksekusi metode `printInfo()` yang benar sesuai dengan tipe objek aslinya saat diinstansiasi, meskipun *list* tersebut secara statis dideklarasikan untuk menampung tipe kelas induknya.
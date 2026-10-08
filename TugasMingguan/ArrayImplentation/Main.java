public class Main {
    public static void main(String[] args) {
        ArrayInteger angka = new ArrayInteger();
        angka.tambah(10);
        angka.tambah(20);
        angka.tambah(30);
        angka.tambah(40);
        angka.tambah(50);
        angka.hapus(1);

        ArrayString buah = new ArrayString();
        buah.tambah("Apel");
        buah.tambah("Jeruk");
        buah.tambah("Mangga");

        // Polymorphism: objek turunan dipanggil melalui tipe induknya.
        ArrayDasar[] kumpulanArray = {angka, buah};
        for (ArrayDasar array : kumpulanArray) {
            array.tampilkan();
        }

        System.out.println("Nilai pada indeks 1: " + angka.ambil(1));
        System.out.println("Indeks Jeruk: " + buah.cari("Jeruk"));
        System.out.println("Jumlah seluruh angka: " + angka.jumlahkan());
    }
}

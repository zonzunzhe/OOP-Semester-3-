import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Bentuk> daftarBentuk = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n--- Menu Bentuk ---");
            System.out.println("1. Tambah Bentuk Umum");
            System.out.println("2. Tambah Bujur Sangkar");
            System.out.println("3. Tambah Lingkaran");
            System.out.println("4. Tambah Silinder");
            System.out.println("5. Tampilkan Semua Bentuk");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan warna bentuk: ");
                    String warnaBentuk = scanner.nextLine();
                    daftarBentuk.add(new Bentuk(warnaBentuk));
                    System.out.println("Bentuk berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan warna bujur sangkar: ");
                    String warnaBujur = scanner.nextLine();
                    System.out.print("Masukkan panjang sisi: ");
                    double sisi = scanner.nextDouble();
                    daftarBentuk.add(new BujurSangkar(sisi, warnaBujur));
                    System.out.println("Bujur Sangkar berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.print("Masukkan warna lingkaran: ");
                    String warnaLingkaran = scanner.nextLine();
                    System.out.print("Masukkan panjang radius: ");
                    double radius = scanner.nextDouble();
                    daftarBentuk.add(new Lingkaran(radius, warnaLingkaran));
                    System.out.println("Lingkaran berhasil ditambahkan!");
                    break;
                case 4:
                    System.out.print("Masukkan warna silinder: ");
                    String warnaSilinder = scanner.nextLine();
                    System.out.print("Masukkan panjang radius alas: ");
                    double radiusSilinder = scanner.nextDouble();
                    System.out.print("Masukkan tinggi silinder: ");
                    double tinggi = scanner.nextDouble();
                    daftarBentuk.add(new Silinder(tinggi, radiusSilinder, warnaSilinder));
                    System.out.println("Silinder berhasil ditambahkan!");
                    break;
                case 5:
                    System.out.println("\n--- Daftar Bentuk ---");
                    if (daftarBentuk.isEmpty()) {
                        System.out.println("Belum ada bentuk yang ditambahkan.");
                    } else {
                        for (Bentuk b : daftarBentuk) {
                            b.printInfo();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        
        scanner.close();
    }
}
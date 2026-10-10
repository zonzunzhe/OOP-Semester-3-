import java.util.Scanner;
import java.util.ArrayList;

public class BankAccountDemo {
    public static void main(String[] args) {
        ArrayList<BankAccount> daftarAkun = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Sistem Bank ---");
            System.out.println("Total Transaksi Valid: " + BankAccount.getValidTransactionCount());
            System.out.println("1. Tambah Akun Reguler");
            System.out.println("2. Tambah Akun Tabungan (Savings)");
            System.out.println("3. Lakukan Deposito ke Akun Terakhir");
            System.out.println("4. Lakukan Penarikan dari Akun Terakhir");
            System.out.println("5. Tampilkan Semua Akun");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Masukkan saldo awal: ");
                    double saldoAwal = input.nextDouble();
                    daftarAkun.add(new BankAccount(saldoAwal));
                    System.out.println("Akun Reguler berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan saldo awal: ");
                    double saldoTabungan = input.nextDouble();
                    System.out.print("Masukkan desimal persentase bunga (contoh 0.05 untuk 5%): ");
                    double bunga = input.nextDouble();
                    daftarAkun.add(new SavingsAccount(saldoTabungan, bunga));
                    System.out.println("Akun Tabungan berhasil ditambahkan!");
                    break;
                case 3:
                    if (!daftarAkun.isEmpty()) {
                        BankAccount akunAktif = daftarAkun.get(daftarAkun.size() - 1);
                        System.out.print("Masukkan nominal deposito: ");
                        double depo = input.nextDouble();
                        double hasilDepo = akunAktif.deposito(depo);
                        akunAktif.setCurrentBalance(hasilDepo);
                        System.out.println("Deposito sukses.");
                    } else {
                        System.out.println("Belum ada akun. Silakan tambah akun terlebih dahulu.");
                    }
                    break;
                case 4:
                    if (!daftarAkun.isEmpty()) {
                        BankAccount akunAktif = daftarAkun.get(daftarAkun.size() - 1);
                        System.out.print("Masukkan nominal penarikan: ");
                        double tarik = input.nextDouble();
                        double hasilTarik = akunAktif.withdraw(tarik);
                        akunAktif.setCurrentBalance(hasilTarik);
                        System.out.println("Penarikan diproses.");
                    } else {
                        System.out.println("Belum ada akun. Silakan tambah akun terlebih dahulu.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Daftar Semua Akun ---");
                    if (daftarAkun.isEmpty()) {
                        System.out.println("Daftar akun kosong.");
                    } else {
                        for (int i = 0; i < daftarAkun.size(); i++) {
                            System.out.print("Akun " + (i + 1) + ": ");
                            daftarAkun.get(i).printInfo();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Sistem ditutup. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (option != 0);
        
        input.close();
    }
}
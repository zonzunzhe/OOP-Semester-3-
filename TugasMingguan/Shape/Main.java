public class Main {
    public static void main(String[] args) {
        Bentuk bentuk = new Bentuk("Merah");
        bentuk.printInfo();

        BujurSangkar bujurSangkar = new BujurSangkar(5.0, "Biru");
        bujurSangkar.printInfo();

        Lingkaran lingkaran = new Lingkaran(7.0, "Kuning");
        lingkaran.printInfo();

        Silinder silinder = new Silinder(10.0, 7.0, "Hijau");
        silinder.printInfo();
    }
}
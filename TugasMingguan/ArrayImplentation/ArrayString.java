public class ArrayString extends ArrayDasar {
    private String[] data = new String[10];

    public void tambah(String nilai) {
        if (ukuran == data.length) {
            throw new IllegalStateException("Array String sudah penuh.");
        }
        data[ukuran] = nilai;
        ukuran++;
    }

    public String ambil(int indeks) {
        periksaIndeks(indeks);
        return data[indeks];
    }

    public void ubah(int indeks, String nilai) {
        periksaIndeks(indeks);
        data[indeks] = nilai;
    }

    public String hapus(int indeks) {
        periksaIndeks(indeks);
        String nilaiDihapus = data[indeks];
        for (int i = indeks; i < ukuran - 1; i++) {
            data[i] = data[i + 1];
        }
        ukuran--;
        data[ukuran] = null;
        return nilaiDihapus;
    }

    public int cari(String nilai) {
        for (int i = 0; i < ukuran; i++) {
            if (nilai == null ? data[i] == null : nilai.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void tampilkan() {
        System.out.print("Array String: [");
        for (int i = 0; i < ukuran; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println("]");
    }
}

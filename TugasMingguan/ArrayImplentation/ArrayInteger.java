public class ArrayInteger extends ArrayDasar {
    private int[] data = new int[10];

    public void tambah(int nilai) {
        if (ukuran == data.length) {
            throw new IllegalStateException("Array Integer sudah penuh.");
        }
        data[ukuran] = nilai;
        ukuran++;
    }

    public int ambil(int indeks) {
        periksaIndeks(indeks);
        return data[indeks];
    }

    public void ubah(int indeks, int nilai) {
        periksaIndeks(indeks);
        data[indeks] = nilai;
    }

    public int hapus(int indeks) {
        periksaIndeks(indeks);
        int nilaiDihapus = data[indeks];
        for (int i = indeks; i < ukuran - 1; i++) {
            data[i] = data[i + 1];
        }
        ukuran--;
        return nilaiDihapus;
    }

    public int cari(int nilai) {
        for (int i = 0; i < ukuran; i++) {
            if (data[i] == nilai) {
                return i;
            }
        }
        return -1;
    }

    public int jumlahkan() {
        int jumlah = 0;
        for (int i = 0; i < ukuran(); i++) {
            jumlah += ambil(i);
        }
        return jumlah;
    }

    @Override
    public void tampilkan() {
        System.out.print("Array Integer: [");
        for (int i = 0; i < ukuran; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println("]");
    }
}

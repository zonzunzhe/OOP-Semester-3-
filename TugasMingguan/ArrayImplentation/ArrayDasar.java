public abstract class ArrayDasar {
    protected int ukuran;

    public int ukuran() {
        return ukuran;
    }

    public boolean kosong() {
        return ukuran == 0;
    }

    public abstract void tampilkan();

    protected void periksaIndeks(int indeks) {
        if (indeks < 0 || indeks >= ukuran) {
            throw new IndexOutOfBoundsException("Indeks tidak valid: " + indeks);
        }
    }
}

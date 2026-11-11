package model;

import exception.ValidationException;

/** Induk seluruh class entity. Pemilik: Ketua Tim (Arsitek Model). */
public abstract class BaseEntity implements Identifiable {

    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean baru() {
        return id == 0;
    }

    /** Wajib diisi tiap modul. Dipanggil DAO sebelum menyimpan dan mengubah. */
    public abstract void validasi() throws ValidationException;

    /** Teks singkat untuk ditampilkan di antarmuka. */
    public abstract String label();

    @Override
    public boolean equals(Object lain) {
        if (this == lain) return true;
        if (lain == null || getClass() != lain.getClass()) return false;
        return id != 0 && id == ((BaseEntity) lain).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return label();
    }
}

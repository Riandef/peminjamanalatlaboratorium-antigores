
package model;

import exception.ValidationException;

// Pemilik: MODUL MASTER 1
public class Alat extends BaseEntity implements Identifiable {

    // Atribut private
    private int kode;
    private String nama;
    private int jumlahTotal;
    private int jumlahTersedia;

    // Constructor
    public Alat(int kode, String nama,
                int jumlahTotal, int jumlahTersedia) {

        this.kode = kode;
        this.nama = nama;
        this.jumlahTotal = jumlahTotal;
        this.jumlahTersedia = jumlahTersedia;
    }

    // Getter dan Setter Kode
    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    // Getter dan Setter Nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter Jumlah Total
    public int getJumlahTotal() {
        return jumlahTotal;
    }

    public void setJumlahTotal(int jumlahTotal) {
        this.jumlahTotal = jumlahTotal;
    }

    // Getter dan Setter Jumlah Tersedia
    public int getJumlahTersedia() {
        return jumlahTersedia;
    }

    public void setJumlahTersedia(int jumlahTersedia) {
        this.jumlahTersedia = jumlahTersedia;
    }

    // Method Validasi
    @Override
    public void validasi() throws ValidationException {

        if (kode <= 0) {
            throw new ValidationException(
                    "Kode", "harus lebih dari 0"
            );
        }

        if (nama == null || nama.trim().isEmpty()) {
            throw new ValidationException(
                    "Nama", "tidak boleh kosong"
            );
        }

        if (jumlahTotal < 0) {
            throw new ValidationException(
                    "Jumlah Total", "tidak boleh negatif"
            );
        }

        if (jumlahTersedia < 0) {
            throw new ValidationException(
                    "Jumlah Tersedia", "tidak boleh negatif"
            );
        }

        if (jumlahTersedia > jumlahTotal) {
            throw new ValidationException(
                    "Jumlah Tersedia",
                    "tidak boleh melebihi jumlah total"
            );
        }
    }

    // Method Label
    @Override
    public String label() {
        return nama + " (" + kode + ")";
    }
}

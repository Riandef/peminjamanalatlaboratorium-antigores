package model;

import exception.ValidationException;
///** Peminjaman alat

public class Peminjaman extends BaseEntity {

    private int id;
    private int mahasiswaId;
    private int alatId;
    private String tanggalPinjam;
    private String tanggalKembali;


    public Peminjaman() {
    }

    public Peminjaman(int mahasiswaId, int alatId, String tanggalPinjam, String tanggalKembali) {
        this.mahasiswaId = mahasiswaId;
        this.alatId = alatId;
        this.tanggalPinjam = tanggalPinjam;

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMahasiswaId() { return mahasiswaId; }
    public void setMahasiswaId(int mahasiswaId) { this.mahasiswaId = mahasiswaId; }

    public int getAlatId() { return alatId; }
    public void setAlatId(int alatId) { this.alatId = alatId; }

    public String getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(String tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }

    public String getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(String tanggalKembali){ this.tanggalKembali = tanggalKembali; }

    @Override
    public void validasi() throws ValidationException {

        if (mahasiswaId == 0) {
            throw new ValidationException("ID Mahasiswa", "tidak boleh kosong");
        }

        if (alatId == 0) {
            throw new ValidationException("ID Alat", "tidak boleh kosong");
        }

        if (tanggalPinjam == null || tanggalPinjam.trim().isEmpty()) {
            throw new ValidationException("Tanggal Pinjam", "tidak boleh kosong");
        }
        if (!tanggalPinjam.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new ValidationException("Tanggal Pinjam", "harus berformat YYYY-MM-DD");
        }

        if (tanggalKembali != null && !tanggalKembali.trim().isEmpty()) {
            if (!tanggalKembali.compareTo(tanggalPinjam) < 0 {
                throw new ValidationException("tanggal kembali", "tidak boleh mendahului tanggal pinjam");
            }
        }
    }

    @Override
    public String label() {
        return "Peminjaman Alat " + alatId + " oleh Mhs " + mahasiswaId;
    }
}
//package model;
//
//import exception.ValidationException;
//
///** MODUL MASTER 1. Pola yang ditiru mahasiswa untuk modul master temanya. */
//public class peminjaman extends BaseEntity {
//
//    private String nik;
//    private String nama;
//    private String telepon;
//    private String alamat;
//
//    public peminjaman() {
//    }
//
//    public peminjaman(String nik, String nama, String telepon, String alamat) {
//        this.nik = nik;
//        this.nama = nama;
//        this.telepon = telepon;
//        this.alamat = alamat;
//    }
//
//    public String getNik() { return nik; }
//    public void setNik(String nik) { this.nik = nik; }
//
//    public String getNama() { return nama; }
//    public void setNama(String nama) { this.nama = nama; }
//
//    public String getTelepon() { return telepon; }
//    public void setTelepon(String telepon) { this.telepon = telepon; }
//
//    public String getAlamat() { return alamat; }
//    public void setAlamat(String alamat) { this.alamat = alamat; }
//    @Override
//    public void validasi() throws ValidationException {
//
//        if (nik == null || nik.trim().isEmpty()) {
//
//            throw new ValidationException("NIK", "tidak boleh kosong");
//        }
//        if (!nik.matches("\\d{16}")) {
//            throw new ValidationException("NIK", "harus 16 angka");
//        }
//
//        if (nama == null || nama.trim().isEmpty()) {
//            throw new ValidationException("nama", "tidak boleh kosong");
//        }
//    }
//
//    @Override
//    public String label() {
//        return nama + " (" + nik + ")";
//    }
//}

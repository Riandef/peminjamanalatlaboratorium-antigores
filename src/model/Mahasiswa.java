package model;

import exception.ValidationException;

//** MODUL MASTER: Mahasiswa. Pemilik: fauzan azima.*/
public class Mahasiswa  extends BaseEntity {
    private long nim;
    private String nama;
    private String kelas;
    public Mahasiswa() {
    }
    public Mahasiswa (long nim, String nama, String kelas){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
    }

    public long getnim() {return  nim;}
    public void setnim (long nim) {this.nim = nim;}

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getKelas() {return  kelas;}
    public void setKelas(String kelas) {this.kelas = kelas;}

    @Override
    public void validasi() throws  ValidationException{
        if (nim <= 0){
            throw new ValidationException("nim mahasiswa", "tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new ValidationException("nama mahasiswa", "tidak boleh kosong");
        }
    }

    @Override
    public String label(){
        return nama + "(" + nim + ")";
    }

}

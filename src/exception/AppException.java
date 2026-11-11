package exception;

/** Induk seluruh kesalahan aplikasi. Pemilik: Koordinator Mutu. */
public class AppException extends Exception {

    public AppException(String pesan) {
        super(pesan);
    }

    public AppException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }

    /** Pesan yang aman ditampilkan kepada pengguna. */
    public String pesanPengguna() {
        return getMessage();
    }
}
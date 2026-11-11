package exception;

/** Isian pengguna tidak memenuhi aturan. */
public class ValidationException extends AppException {

    private final String namaField;

    public ValidationException(String namaField, String pesan) {
        super(pesan);
        this.namaField = namaField;
    }

    public String getNamaField() {

        return namaField;
    }

    @Override
    public String pesanPengguna() {
        return "Isian " + namaField + " tidak sah: " + getMessage();
    }
}




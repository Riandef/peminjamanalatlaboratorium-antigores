package Latihan;

import javax.swing.*;
import java.awt.*;

public class FormPeminjaman extends JFrame {

    private JTextField fAlatId;
    private JTextField fMahasiswaId;
    private JTextField fTanggalPinjam;
    private JTextField fTanggalKembali;

    public FormPeminjaman() {
        super("Data Peminjaman Alat Laboratorium");
        setSize(800, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        susunKomponen();
    }

    private void susunKomponen() {
        setLayout(new BorderLayout(8, 8));

        JPanel panelAtas = new JPanel();
        panelAtas.add(new JLabel("Nama/Cari:"));
        panelAtas.add(new JTextField(20));
        panelAtas.add(new JButton("Cari"));
        add(panelAtas, BorderLayout.NORTH);

        String[] judulKolom = {"Alat ID", "Mahasiswa ID", "Tgl Pinjam", "Tgl Kembali"};
        Object[][] dataSementara = {{"ALT-001", "220001", "2026-11-01", ""},
                {"ALT-002", "220002", "2026-11-02", "2026-11-05"},
                {"ALT-003", "220003", "2026-11-02", ""}
        };

        JTable tabel = new JTable(dataSementara, judulKolom);
        add(new JScrollPane(tabel), BorderLayout.CENTER);

        JPanel panelIsian = new JPanel(new GridLayout(4, 2, 5, 5));

        fAlatId = new JTextField(14);
        fMahasiswaId = new JTextField(14);
        fTanggalPinjam = new JTextField(14);
        fTanggalKembali = new JTextField(14);

        panelIsian.add(new JLabel("ID Alat:"));
        panelIsian.add(fAlatId);
        panelIsian.add(new JLabel("NIM :"));
        panelIsian.add(fMahasiswaId);
        panelIsian.add(new JLabel("Tgl Pinjam:"));
        panelIsian.add(fTanggalPinjam);
        panelIsian.add(new JLabel("Tgl Kembali:"));
        panelIsian.add(fTanggalKembali);

        add(panelIsian, BorderLayout.EAST);

        JPanel panelBawah = new JPanel();
        panelBawah.add(new JButton("Baru"));
        panelBawah.add(new JButton("Simpan"));
        panelBawah.add(new JButton("Hapus"));
        add(panelBawah, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPeminjaman().setVisible(true));
    }
}
package GUI;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FormAlatTampilan extends JFrame {

    private JTextField fKode;
    private JTextField fNama;
    private JTextField fJumlahTotal;
    private JTextField fJumlahTersedia;

    public FormAlatTampilan() {

        super("Tabel Alat");

        setSize(760, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        susunKomponen();
    }

    private void susunKomponen() {

        setLayout(new BorderLayout(8, 8));

        // Panel atas
        JPanel panelAtas = new JPanel();

        panelAtas.add(new JLabel("Nama:"));
        panelAtas.add(new JTextField(20));
        panelAtas.add(new JButton("Cari"));

        add(panelAtas, BorderLayout.NORTH);

        // Judul kolom tabel
        String[] judulKolom = {
                "Kode",
                "Nama",
                "Jumlah_Total",
                "Jumlah_tersedia"
        };

        // Data sementara alat
        Object[][] dataSementara = {
                {100, "pensil", 10, 5},
                {101, "pena", 10, 6},
                {102, "gelas_kaca", 5, 2},
                {103, "pisau", 3, 1}
        };

        // Membuat tabel alat
        JTable tabel = new JTable(dataSementara, judulKolom);

        add(new JScrollPane(tabel), BorderLayout.CENTER);

        // Field isian
        fKode = new JTextField(14);
        fNama = new JTextField(14);
        fJumlahTotal = new JTextField(14);
        fJumlahTersedia = new JTextField(14);

        // Larik isian
        JTextField[] isian = {
                fKode,
                fNama,
                fJumlahTotal,
                fJumlahTersedia
        };

        // Panel isian
        add(
                buatPanelIsian(
                        new String[]{
                                "Kode",
                                "Nama",
                                "Jumlah Total",
                                "Jumlah Tersedia"
                        },
                        isian
                ),
                BorderLayout.EAST
        );

        // Panel bawah
        JPanel panelBawah = new JPanel();

        panelBawah.add(new JButton("Baru"));
        panelBawah.add(new JButton("Simpan"));
        panelBawah.add(new JButton("Hapus"));

        add(panelBawah, BorderLayout.SOUTH);
    }

    private JPanel buatPanelIsian(
            String[] judul,
            JTextField[] isian
    ) {

        JPanel kolomLabel = new JPanel(
                new GridLayout(judul.length, 1, 6, 6)
        );

        JPanel kolomIsian = new JPanel(
                new GridLayout(isian.length, 1, 6, 6)
        );

        for (int i = 0; i < judul.length; i++) {

            kolomLabel.add(new JLabel(judul[i]));

            kolomIsian.add(isian[i]);
        }

        JPanel panel = new JPanel(
                new BorderLayout(6, 0)
        );

        panel.setBorder(
                BorderFactory.createTitledBorder("Isian")
        );

        panel.add(kolomLabel, BorderLayout.WEST);

        panel.add(kolomIsian, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new FormAlatTampilan().setVisible(true)
        );
    }
}


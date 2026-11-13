package latihan;

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

public class FormMahasiswaTampilan extends JFrame {
    private JTextField fNim;
    private JTextField fNama;
    private JTextField fkelas;

    public FormMahasiswaTampilan(){
        super("Data Mahasiwa");
        setSize(760,420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        susunKomponen();
    }
    private void susunKomponen(){
        setLayout(new BorderLayout(8,8));
        JPanel panelAtas= new JPanel();
        panelAtas.add(new JLabel("Nama:"));
        panelAtas.add(new JTextField(20));
        panelAtas.add(new JButton("Cari"));
        add(panelAtas,BorderLayout.NORTH);

        String[] judulKolom= {"NIM", "Nama","Kelas" };
        Object[][] dataSementara = {
                {"6304250012", "Defrian Syahputra", "RPL 3C"},
                {"6304250066", "Fauzan Azima", "RPL 3C"},
                {"6304250078", "Muhammad Arbi Firmansyah", "RPL 3C"},
                {"6304250045", "Zahratul Wafi", "RPL 3C"},
        };

        JTable tabel =new JTable(dataSementara, judulKolom);
        add(new JScrollPane(tabel),BorderLayout.CENTER);

        fNim = new JTextField(14);
        fNama = new JTextField(14);
        fkelas = new JTextField(14);

        JTextField[] isian = {fNim, fNama,fkelas};
        add(buatPanelIsian(new String[] {"Nim", "Nama","Kelas"}, isian),
               BorderLayout.EAST );

        JPanel panelBawah= new JPanel();
        panelBawah.add(new JButton("Baru"));
        panelBawah.add(new JButton("Simpan"));
        panelBawah.add(new JButton("Hapus"));
        add(panelBawah, BorderLayout.SOUTH);

    }
    private JPanel buatPanelIsian(String[] judul, JTextField[] isian) {
        JPanel kolomLabel = new JPanel(new GridLayout(judul.length, 1, 6, 6));
        JPanel kolomIsian = new JPanel(new GridLayout(isian.length, 1, 6, 6));
        for (int i = 0; i < judul.length; i++) {
            kolomLabel.add(new JLabel(judul[i]));
            kolomIsian.add(isian[i]);
        }
        JPanel panel = new JPanel(new BorderLayout(6, 0));
        panel.setBorder(BorderFactory.createTitledBorder("Isian"));
        panel.add(kolomLabel, BorderLayout.WEST);
        panel.add(kolomIsian, BorderLayout.CENTER);
        return panel;
    }
    JTextField[] isian = {
            new JTextField(14), new JTextField(14),
            new JTextField(14), new JTextField(14)
    };

    public static void main (String[]args){
        SwingUtilities.invokeLater(()-> new FormMahasiswaTampilan().setVisible(true));
    }
}

package Latihan;
import javax.swing.*;
import java.awt.*;


public class FormBeranda extends JFrame {
    public FormBeranda() {
        super("Beranda ");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        susunKomponen();
    }

    private void susunKomponen() {
        setLayout(new BorderLayout(8, 8));
        JPanel panelTombol = new JPanel();
        panelTombol.add(new JButton(" Menu Detail Alat"));
        panelTombol.add(new JButton("Menu Mahasiswa"));
        panelTombol.add(new JButton("Menu Laboratorium"));
        panelTombol.add(new JButton("Menu Peminjaman"));
        panelTombol.add(new JButton("Keluar"));
        add(panelTombol, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormBeranda().setVisible(true));
    }

}

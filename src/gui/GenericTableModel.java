package gui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/** Satu model tabel untuk semua modul. Pemilik: Koordinator Antarmuka. */
public class GenericTableModel<T> extends AbstractTableModel {

    private final String[] judulKolom;
    private final Function<T, Object[]> pembaris;
    private List<T> data = new ArrayList<T>();

    public GenericTableModel(String[] judulKolom, Function<T, Object[]> pembaris) {
        this.judulKolom = judulKolom;
        this.pembaris = pembaris;
    }

    public void isiUlang(List<T> dataBaru) {
        this.data = dataBaru;
        fireTableDataChanged();
    }

    public T baris(int indeks) {
        return data.get(indeks);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return judulKolom.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return judulKolom[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        return pembaris.apply(data.get(baris))[kolom];
    }
}

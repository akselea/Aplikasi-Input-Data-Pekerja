/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LordAxl
 */
public class TabelDataPengguna extends AbstractTableModel {
    
    private List<DataPengguna> list = new ArrayList<DataPengguna>();
    
    @Override
    public int getRowCount() {
            return list.size();
    }
    
    @Override
    public int getColumnCount() {
            return 5;
    }
    
    @Override
    public Object getValueAt (int rowIndex, int columnIndex) {
       switch (columnIndex) {
           case 0:
               return list.get(rowIndex).getPengguna();
           case 1:
               return list.get(rowIndex).getUsernamePengguna();
           case 2:
               return list.get(rowIndex).getPasswordPengguna();
           case 3:
               return list.get(rowIndex).getNamaPengguna();
           case 4:
               return list.get(rowIndex).getHakPengguna();
           default:
               return null;
       }
    }
    
    @Override
    public String getColumnName (int kolom) {
    switch (kolom) {
        case 0:
            return "ID Pengguna";
        case 1:
            return "Username";
        case 2:
            return "Password";
        case 3:
            return "Nama Pengguna";
        case 4:
            return "Hak Admin";
        default:
            return null;   
        }
    }
    
    public void add(DataPengguna pengguna) {
        list.add(pengguna);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    public DataPengguna get (int baris) {
        return (DataPengguna) list.get(baris);
    }
}

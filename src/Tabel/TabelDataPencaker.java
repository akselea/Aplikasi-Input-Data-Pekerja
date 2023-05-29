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
public class TabelDataPencaker extends AbstractTableModel {
    
    private List<DataPencaker> list = new ArrayList<DataPencaker>();
    
    @Override
    public int getRowCount() {
            return list.size();
    }
    
    @Override
    public int getColumnCount() {
            return 16;
    }
    
    @Override
    public Object getValueAt (int rowIndex, int columnIndex) {
       switch (columnIndex) {
           case 0:
               return list.get(rowIndex).getPencaker();
           case 1:
               return list.get(rowIndex).getKtpPencaker();
           case 2:
               return list.get(rowIndex).getNamaPencaker();
           case 3:
               return list.get(rowIndex).getTempatLahirPencaker();
           case 4:
               return list.get(rowIndex).getTanggalLahirPencaker();
           case 5:
               return list.get(rowIndex).getJenisKelaminPencaker();
           case 6:
               return list.get(rowIndex).getAgamaPencaker();
           case 7:
               return list.get(rowIndex).getKewarganegaraanPencaker();
           case 8:
               return list.get(rowIndex).getStatusPencaker();
           case 9:
               return list.get(rowIndex).getPendidikanPencaker();
           case 10:
               return list.get(rowIndex).getSekolahPencaker();
           case 11:
               return list.get(rowIndex).getJurusanPencaker();
           case 12:
               return list.get(rowIndex).getTahunLulusPencaker();
           case 13:
               return list.get(rowIndex).getAlamatPencaker();
           case 14:
               return list.get(rowIndex).getKecakeluPencaker();
           case 15:
               return list.get(rowIndex).getTelponPencaker();
           default:
               return null;
       }
    }
    
    @Override
    public String getColumnName (int kolom) {
    switch (kolom) {
        case 0:
            return "ID Pencaker";
        case 1:
            return "No. KTP";
        case 2:
            return "Nama";
        case 3:
            return "Tempat Lahir";
        case 4:
            return "Tanggal Lahir";
        case 5:
            return "Jenis Kelamin";
        case 6:
            return "Agama";
        case 7:
            return "Kewarganegaraan";
        case 8:
            return "Status";
        case 9:
            return "Pendidikan Terakhir";
        case 10:
            return "Nama Sekolah";
        case 11:
            return "Jurusan";
        case 12:
            return "Tahun Lulus";
        case 13:
            return "Alamat";
        case 14:
            return "Kecamatan / Kelurahan";
        case 15:
            return "No. Telp";
        default:
            return null;   
        }
    }
    
    public void add(DataPencaker pencaker) {
        list.add(pencaker);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    public DataPencaker get (int baris) {
        return (DataPencaker) list.get(baris);
    }

    public int getSelectedRow(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

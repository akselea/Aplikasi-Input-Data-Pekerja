/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.HalamanUtamaAdmin.getTanggalFromTable;
import Tabel.*;
import Koneksi.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author LordAxl
 */
public final class HalamanUtamaUser extends javax.swing.JFrame {
    String HakAkses,Nama;
    private Object tabel;
    private TabelDataPencaker ModelDataPencaker;
    private Koneksi conn;
    ResultSet rs;
    
    /**
     * Creates new form HalamanUtamaUser
     */
    public HalamanUtamaUser() {
        initComponents();
        
        ModelDataPencaker = new TabelDataPencaker();
        TblDataPencaker.setModel(ModelDataPencaker);
        
        conn=new Koneksi();
        
        TampilPencaker();
        SetEditOffViewPencaker();
        
        txtIDPencakerView.setEnabled(false);

        panelViewPencaker.setVisible(false);
        
        mInputIDBaru.setEnabled(false);
        mInputDataPencaker.setEnabled(false);
        mViewDaftarID.setEnabled(false);
    }
  
    public static java.util.Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        java.util.Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException ex) {
            Logger.getLogger(DataPencaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
    }
    
    private void TampilPencaker() {
    try {
        int baris = TblDataPencaker.getRowCount();
        for (int i = 0; i < baris; i++) {
            ModelDataPencaker.delete(0, baris);
        }
        String sql = "select * from pencaker";
        ResultSet rs = conn.getData(sql);
        while (rs.next()) {
            DataPencaker pencaker = new DataPencaker();
            pencaker.setPencaker(rs.getString(1));
            pencaker.setKtpPencaker(rs.getString(2));
            pencaker.setNamaPencaker(rs.getString(3));
            pencaker.setTempatLahirPencaker(rs.getString(4));
            pencaker.setTanggalLahirPencaker(rs.getString(5));
            pencaker.setJenisKelaminPencaker(rs.getString(6));
            pencaker.setAgamaPencaker(rs.getString(7));
            pencaker.setKewarganegaraanPencaker(rs.getString(8));
            pencaker.setStatusPencaker(rs.getString(9));
            pencaker.setPendidikanPencaker(rs.getString(10));
            pencaker.setSekolahPencaker(rs.getString(11));
            pencaker.setJurusanPencaker(rs.getString(12));
            pencaker.setTahunLulusPencaker(rs.getString(13));
            pencaker.setAlamatPencaker(rs.getString(14));
            pencaker.setKecakeluPencaker(rs.getString(15));
            pencaker.setTelponPencaker(rs.getString(16));
            ModelDataPencaker.add(pencaker);     
        }
    } catch (SQLException ex) {
        System.err.print (ex);
    }
}
    
    int row = 0;    
    public void TampilTextPencaker() {
        row = TblDataPencaker.getSelectedRow();
        DataPencaker dPencaker = ModelDataPencaker.get(row);
        txtNoKTPView.setText(dPencaker.getKtpPencaker());
        txtNamaPencakerView.setText(dPencaker.getNamaPencaker());
        txtTempatLahirView.setText(dPencaker.getTempatLahirPencaker());
        cbJenisKelaminView.setSelectedItem(dPencaker.getJenisKelaminPencaker());
        cbAgamaView.setSelectedItem(dPencaker.getAgamaPencaker());
        cbKewarganegaraanView.setSelectedItem(dPencaker.getKewarganegaraanPencaker());
        cbStatusView.setSelectedItem(dPencaker.getStatusPencaker());
        cbPendidikanView.setSelectedItem(dPencaker.getPendidikanPencaker());
        txtNamaSekolahView.setText(dPencaker.getSekolahPencaker());
        txtJurusanView.setText(dPencaker.getJurusanPencaker());
        txtTahunLulusView.setText(dPencaker.getTahunLulusPencaker());
        txtAlamatView.setText(dPencaker.getAlamatPencaker());
        cbKecaKeluView.setSelectedItem(dPencaker.getKecakeluPencaker());
        txtNoHpView.setText(dPencaker.getTelponPencaker());
        txtIDPencakerView.setText(dPencaker.getPencaker());
        SetEditOnViewPencaker();
    }
    
    public void SetEditOffViewPencaker() {
        txtNoKTPView.setEnabled(false);
        txtNamaPencakerView.setEnabled(false);
        txtTempatLahirView.setEnabled(false);
        dtTglLahirView.setEnabled(false);
        cbJenisKelaminView.setEnabled(false);
        cbAgamaView.setEnabled(false);    
        cbKewarganegaraanView.setEnabled(false);
        cbStatusView.setEnabled(false);
        cbPendidikanView.setEnabled(false);
        txtNamaSekolahView.setEnabled(false);
        txtJurusanView.setEnabled(false);
        txtTahunLulusView.setEnabled(false);
        txtAlamatView.setEnabled(false);
        cbKecaKeluView.setEnabled(false);    
        txtNoHpView.setEnabled(false);
        cbStatusView.setEnabled(false);
        btnDeletePencakerView.setEnabled(false);
        btnUpdatePencakerView.setEnabled(false);    
        btnCancelPencakerView.setEnabled(false);
        btnClosePencakerView.setEnabled(true);
    }
    
    public void SetEditOnViewPencaker() {
        txtNoKTPView.setEditable(false);
        txtNamaPencakerView.setEditable(false);
        txtTempatLahirView.setEditable(false);
        dtTglLahirView.setEnabled(false);
        cbJenisKelaminView.setEditable(false);
        cbAgamaView.setEditable(false);    
        cbKewarganegaraanView.setEditable(false);
        cbStatusView.setEditable(false);
        cbPendidikanView.setEditable(false);
        txtNamaSekolahView.setEditable(false);
        txtJurusanView.setEditable(false);
        txtTahunLulusView.setEditable(false);
        txtAlamatView.setEditable(false);
        cbKecaKeluView.setEditable(false);    
        txtNoHpView.setEditable(false);
        cbStatusView.setEditable(false);
        btnDeletePencakerView.setEnabled(false);
        btnUpdatePencakerView.setEnabled(false);    
        btnCancelPencakerView.setEnabled(true);
        btnClosePencakerView.setEnabled(false);
    }

    public void BersihDataViewPencaker() {
        txtNoKTPView.setText("");
        txtNamaPencakerView.setText("");
        txtTempatLahirView.setText("");
        dtTglLahirView.setDate(null);
        cbJenisKelaminView.setSelectedItem("--- Pilih ---");
        cbAgamaView.setSelectedItem("--- Pilih ---");
        cbKewarganegaraanView.setSelectedItem("--- Pilih ---");
        cbStatusView.setSelectedItem("--- Pilih ---");
        cbPendidikanView.setSelectedItem("--- Pilih ---");
        txtNamaSekolahView.setText("");
        txtJurusanView.setText("");
        txtTahunLulusView.setText("");
        txtAlamatView.setText("");
        cbKecaKeluView.setSelectedItem("--- Pilih ---");
        txtNoHpView.setText("");
        txtIDPencakerView.setText("");
    }
    
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelViewPencaker = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDataPencaker = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        txtAlamatView = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cbKecaKeluView = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        txtTempatLahirView = new javax.swing.JTextField();
        txtNoHpView = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        btnDeletePencakerView = new javax.swing.JButton();
        cbJenisKelaminView = new javax.swing.JComboBox<>();
        btnCancelPencakerView = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        btnClosePencakerView = new javax.swing.JButton();
        cbAgamaView = new javax.swing.JComboBox<>();
        txtIDPencakerView = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cbKewarganegaraanView = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        cbStatusView = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        cbPendidikanView = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        txtNamaSekolahView = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtJurusanView = new javax.swing.JTextField();
        txtNoKTPView = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtTahunLulusView = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtNamaPencakerView = new javax.swing.JTextField();
        btnUpdatePencakerView = new javax.swing.JButton();
        dtTglLahirView = new com.toedter.calendar.JDateChooser();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mKeluar = new javax.swing.JMenuItem();
        mLogout = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mInputIDBaru = new javax.swing.JMenuItem();
        mInputDataPencaker = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mViewDaftarID = new javax.swing.JMenuItem();
        mViewPencaker = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        TblDataPencaker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblDataPencaker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDataPencakerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblDataPencaker);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Alamat");

        txtAlamatView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Tempat Lahir");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Kecamatan / Kelurahan");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Tanggal Lahir");

        cbKecaKeluView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbKecaKeluView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "Andir / Campaka / 40184", "Andir / Ciroyom / 40182", "Andir / Dungus Cariang / 40183", "Andir / Garuda / 40184", "Andir / Kebon Jeruk / 40181", "Andir / Maleber / 40184", "Antapani / Antapani Kidul / 40291", "Antapani / Antapani Kulon / 40291", "Antapani / Antapani Tengah / 40291", "Antapani / Antapani Wetan / 40291", "Arcamanik / Cisaranten Endah / 40293", "Arcamanik / Cisaranten Kulon / 40293", "Arcamanik / Cisaranten Bina Harapan / 40294", "Arcamanik / Sindang Jaya / 40293", "Arcamanik / Sukamiskin / 40293", "Astana Anyar / Cibadak / 40241", "Astana Anyar / Karanganyar / 40241", "Astana Anyar / Karasak / 40243", "Astana Anyar / Nyengseret / 40242", "Astana Anyar / Panjunan / 40242", "Astana Anyar / Pelindung Hewan / 40243", "Babakan Ciparay / Babakan / 40222", "Babakan Ciparay / Babakan Ciparay / 40223", "Babakan Ciparay / Cirangrang / 40227", "Babakan Ciparay / Margahayu Utara / 40224", "Babakan Ciparay / Margasuka / 40225", "Babakan Ciparay / Sukahaji / 40221", "Bandung Kidul / Mengger / 40267", "Bandung Kidul / Batununggal / 40266", "Bandung Kidul / Kujangsari / 40287", "Bandung Kidul / Wates / 40256", "Bandung Kulon / Caringin / 40212", "Bandung Kulon / Cibuntu / 40212", "Bandung Kulon / Cigondewah Kaler / 40214", "Bandung Kulon / Cigondewah Kidul / 40214", "Bandung Kulon / Cigondewah Rahayu / 40215", "Bandung Kulon / Cijerah / 40213", "Bandung Kulon / Gempolsari / 40215", "Bandung Kulon / Warung Muncang / 40211", "Bandung Wetan / Cihapit / 40114", "Bandung Wetan / Citarum / 40115", "Bandung Wetan / Tamansari / 40116", "Batununggal / Binong / 40275", "Batununggal / Cibangkong / 40273", "Batununggal / Gumuruh / 40275", "Batununggal / Kacapiring / 40271", "Batununggal / Kebon Gedang / 40274", "Batununggal / Kebonwaru / 40272", "Batununggal / Maleer / 40274", "Batununggal / Samoja / 40273", "Bojongloa Kaler / Babakan Asih / 40232", "Bojongloa Kaler / Babakan Tarogong / 40232", "Bojongloa Kaler / Jamika / 40231", "Bojongloa Kaler / Kopo / 40233", "Bojongloa Kaler / Suka Asih / 40231", "Bojongloa Kidul / Cibaduyut / 40236", "Bojongloa Kidul / Cibaduyut Kidul / 40239", "Bojongloa Kidul / Cibaduyut Wetan / 40238", "Bojongloa Kidul / Kebon Lega / 40235", "Bojongloa Kidul / Mekarwangi / 40237", "Bojongloa Kidul / Situsaeur / 40234", "Buahbatu  / Cijawura / 40287", "Buahbatu  / Jatisari / 40286", "Buahbatu  / Margasari / 40286", "Buahbatu  / Sekejati / 40286", "Cibeunying Kaler / Cigadung / 40191", "Cibeunying Kaler / Cihaur Geulis / 40122", "Cibeunying Kaler / Neglasari / 40124", "Cibeunying Kaler / Sukaluyu / 40123", "Cibeunying Kidul / Cicadas / 40121", "Cibeunying Kidul / Cikutra / 40124", "Cibeunying Kidul / Padasuka / 40125", "Cibeunying Kidul / Pasirlayung / 40192", "Cibeunying Kidul / Sukamaju / 40121", "Cibeunying Kidul / Sukapada / 40125", "Cibiru / Cipadung / 40614", "Cibiru / Cisurupan / 40614", "Cibiru / Palasari / 40615", "Cibiru / Pasirbiru / 40615", "Cicendo / Arjuna / 40172", "Cicendo / Husein Sastranegara / 40174", "Cicendo / Pajajaran / 40173", "Cicendo / Pamoyanan / 40173", "Cicendo / Pasir Kaliki / 40171", "Cicendo / Sukaraja / 40175", "Cidadap / Ciumbuleuit / 40142", "Cidadap / Hegarmanah / 40141", "Cidadap / Ledeng / 40143", "Cinambo / Babakan Penghulu / 40294", "Cinambo / Cisaranten Wetan / 40294", "Cinambo / Pakemitan / 40294", "Cinambo / Sukamulya / 40294", "Coblong / Cipaganti / 40131", "Coblong / Dago / 40135", "Coblong / Lebak Gede / 40132", "Coblong / Lebak Siliwangi / 40132", "Coblong / Sadang Serang / 40133", "Coblong / Sekeloa / 40134", "Gedebage / Cimincrang  / 40295", "Gedebage / Cisaranten Kidul / 40295", "Gedebage / Rancabolang / 40295", "Gedebage / Rancanumpang / 40295", "Kiaracondong / Babakan Sari / 40283", "Kiaracondong / Babakan Surabaya / 40281", "Kiaracondong / Cicaheum / 40282", "Kiaracondong / Kebon Jayanti / 40281", "Kiaracondong / Kebon Kangkung / 40284", "Kiaracondong / Sukapura / 40285", "Lengkong / Burangrang / 40262", "Lengkong / Cijagra / 40265", "Lengkong / Cikawao / 40261", "Lengkong / Lingkar Selatan / 40263", "Lengkong / Malabar / 40262", "Lengkong / Paledang / 40261", "Lengkong / Turangga / 40264", "Mandala Jati / Jatihandap / 40195", "Mandala Jati / Karang Pamulang / 40195", "Mandala Jati / Pasir Impun / 40195", "Mandala Jati / Sindang Jaya / 40195", "Panyileukan / Cipadung Kidul / 40614", "Panyileukan / Cipadung Kulon / 40614", "Panyileukan / Cipadung Wetan / 40614", "Panyileukan / Mekarmulya / 40613", "Rancasari / Cipamokolan / 40292", "Rancasari / Derwati / 40292", "Rancasari / Manjahlega / 40295", "Rancasari / Mekar Jaya / 40292", "Regol / Ancol / 40254", "Regol / Balong Gede / 40251", "Regol / Ciateul / 40252", "Regol / Cigereleng / 40253", "Regol / Ciseureuh / 40255", "Regol / Pasirluyu / 40254", "Regol / Pungkur / 40252", "Sukajadi / Cipedes / 40162", "Sukajadi / Pasteur / 40161", "Sukajadi / Sukabungah / 40162", "Sukajadi / Sukagalih / 40163", "Sukajadi / Sukawarna / 40164", "Sukasari / Geger Kalong / 40153", "Sukasari / Isola / 40154", "Sukasari / Sarijadi / 40151", "Sukasari / Sukarasa / 40152", "Sumur Bandung / Babakan Ciamis / 40117", "Sumur Bandung / Braga / 40111", "Sumur Bandung / Kebon Pisang / 40112", "Sumur Bandung / Merdeka / 40113", "Ujung Berung / Cigending / 40611", "Ujung Berung / Pasanggrahan / 40617", "Ujung Berung / Pasir Endah / 40619", "Ujung Berung / Pasirjati / 40616", "Ujung Berung / Pasirwangi / 40618", "Ujung Berung / Ujung Berung / 40611" }));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("No. Telfon / Handphone");

        txtTempatLahirView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTempatLahirView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempatLahirViewActionPerformed(evt);
            }
        });

        txtNoHpView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNoHpView.setToolTipText("");
        txtNoHpView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoHpViewKeyTyped(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Jenis Kelamin");

        btnDeletePencakerView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDeletePencakerView.setText("Delete");
        btnDeletePencakerView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePencakerViewActionPerformed(evt);
            }
        });

        cbJenisKelaminView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbJenisKelaminView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "Pria", "Wanita" }));

        btnCancelPencakerView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelPencakerView.setText("Cancel");
        btnCancelPencakerView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelPencakerViewActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Agama");

        btnClosePencakerView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClosePencakerView.setText("Close");
        btnClosePencakerView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosePencakerViewActionPerformed(evt);
            }
        });

        cbAgamaView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbAgamaView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "Islam", "Kristen-Protestan", "Kristen-Katolik", "Kristen", "Hindu", "Budha", "Lainnya" }));

        txtIDPencakerView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Kewarganegaraan");

        cbKewarganegaraanView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbKewarganegaraanView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "WNI", "WNA" }));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Status");

        cbStatusView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbStatusView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "Belum Kawin", "Kawin", "Duda", "Janda" }));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Pendidikan Terakhir");

        cbPendidikanView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPendidikanView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---", "SD", "SMP", "SMA", "SMK", "D1", "D2", "D3", "D4", "S1", "S2", "S3" }));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Nama Sekolah / Universitas");

        txtNamaSekolahView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Jurusan");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel56.setText("Form Input Data Pencari Kerja");

        txtJurusanView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNoKTPView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNoKTPView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoKTPViewActionPerformed(evt);
            }
        });
        txtNoKTPView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoKTPViewKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoKTPViewKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoKTPViewKeyTyped(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setText("Tahun Lulus");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("No. KTP");

        txtTahunLulusView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTahunLulusView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTahunLulusViewKeyTyped(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setText("Nama");

        txtNamaPencakerView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnUpdatePencakerView.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdatePencakerView.setText("Update");
        btnUpdatePencakerView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePencakerViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelViewPencakerLayout = new javax.swing.GroupLayout(panelViewPencaker);
        panelViewPencaker.setLayout(panelViewPencakerLayout);
        panelViewPencakerLayout.setHorizontalGroup(
            panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                .addComponent(btnUpdatePencakerView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 32, Short.MAX_VALUE)
                                .addComponent(btnDeletePencakerView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelPencakerView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClosePencakerView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIDPencakerView, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(cbKewarganegaraanView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(cbStatusView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewPencakerLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtNamaPencakerView, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNoKTPView, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTempatLahirView, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbPendidikanView, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbAgamaView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                                .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18))
                                            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTahunLulusView)
                                            .addComponent(txtNamaSekolahView)
                                            .addComponent(txtJurusanView)
                                            .addComponent(txtAlamatView)
                                            .addComponent(cbKecaKeluView, 0, 200, Short.MAX_VALUE)))
                                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNoHpView, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewPencakerLayout.createSequentialGroup()
                                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(dtTglLahirView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewPencakerLayout.createSequentialGroup()
                                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbJenisKelaminView, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        panelViewPencakerLayout.setVerticalGroup(
            panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewPencakerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewPencakerLayout.createSequentialGroup()
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoKTPView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txtNamaPencakerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtTempatLahirView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addComponent(dtTglLahirView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(cbJenisKelaminView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(cbAgamaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(cbKewarganegaraanView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(cbStatusView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(cbPendidikanView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(txtNamaSekolahView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(txtJurusanView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtTahunLulusView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtAlamatView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(cbKecaKeluView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtNoHpView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewPencakerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeletePencakerView)
                            .addComponent(btnCancelPencakerView)
                            .addComponent(btnClosePencakerView)
                            .addComponent(txtIDPencakerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdatePencakerView)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jMenu3.setMnemonic('l');
        jMenu3.setText("File");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        mKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK));
        mKeluar.setText("Keluar Aplikasi");
        mKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKeluarActionPerformed(evt);
            }
        });
        jMenu3.add(mKeluar);

        mLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK));
        mLogout.setMnemonic('l');
        mLogout.setText("Logout");
        mLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLogoutActionPerformed(evt);
            }
        });
        jMenu3.add(mLogout);

        jMenuBar2.add(jMenu3);

        jMenu4.setMnemonic('I');
        jMenu4.setText("Input");

        mInputIDBaru.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK));
        mInputIDBaru.setMnemonic('i');
        mInputIDBaru.setText("Input ID Baru");
        mInputIDBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInputIDBaruActionPerformed(evt);
            }
        });
        jMenu4.add(mInputIDBaru);

        mInputDataPencaker.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.SHIFT_MASK));
        mInputDataPencaker.setMnemonic('i');
        mInputDataPencaker.setText("Input Data Pencaker");
        mInputDataPencaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInputDataPencakerActionPerformed(evt);
            }
        });
        jMenu4.add(mInputDataPencaker);

        jMenuBar2.add(jMenu4);

        jMenu5.setMnemonic('v');
        jMenu5.setText("View");

        mViewDaftarID.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.SHIFT_MASK));
        mViewDaftarID.setMnemonic('l');
        mViewDaftarID.setText("Lihat Daftar ID");
        mViewDaftarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewDaftarIDActionPerformed(evt);
            }
        });
        jMenu5.add(mViewDaftarID);

        mViewPencaker.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.SHIFT_MASK));
        mViewPencaker.setMnemonic('l');
        mViewPencaker.setText("Lihat Data Pencaker");
        mViewPencaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewPencakerActionPerformed(evt);
            }
        });
        jMenu5.add(mViewPencaker);

        jMenuBar2.add(jMenu5);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelViewPencaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelViewPencaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1110, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKeluarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, " Aplikasi Ini Akan Tertutup " + "\n Jika Kamu Memencet Tombol OK", "Peringatan",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)
        ==JOptionPane.OK_OPTION){
        this.dispose();
        }
    }//GEN-LAST:event_mKeluarActionPerformed

    private void mLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLogoutActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, " Anda Akan Logout" + "\n Apakah Anda Yakin ?", "Peringatan",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)
        ==JOptionPane.OK_OPTION){
        JOptionPane.showMessageDialog(null, "Anda Telah Logout");
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_mLogoutActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void mInputIDBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInputIDBaruActionPerformed
        // TODO add your handling code here:
        panelViewPencaker.setVisible(false);
    }//GEN-LAST:event_mInputIDBaruActionPerformed

    private void mInputDataPencakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInputDataPencakerActionPerformed
        // TODO add your handling code here:
        panelViewPencaker.setVisible(false);
    }//GEN-LAST:event_mInputDataPencakerActionPerformed

    private void mViewDaftarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewDaftarIDActionPerformed
        // TODO add your handling code here:
        panelViewPencaker.setVisible(false);;
    }//GEN-LAST:event_mViewDaftarIDActionPerformed

    private void mViewPencakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewPencakerActionPerformed
        // TODO add your handling code here:
        panelViewPencaker.setVisible(true);
    }//GEN-LAST:event_mViewPencakerActionPerformed

    private void TblDataPencakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDataPencakerMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            TampilTextPencaker();
            dtTglLahirView.setDate(getTanggalFromTable(TblDataPencaker, 4));
        }
    }//GEN-LAST:event_TblDataPencakerMouseClicked

    private void txtTempatLahirViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempatLahirViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempatLahirViewActionPerformed

    private void txtNoHpViewKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpViewKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHpViewKeyTyped

    private void btnDeletePencakerViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePencakerViewActionPerformed
        // TODO add your handling code here:
        String KTPV = txtNoKTPView.getText();
        String NPV = txtNamaPencakerView.getText();
        String TLV = txtTempatLahirView.getText();
        String NSV = txtNamaSekolahView.getText();
        String JV = txtJurusanView.getText();
        String THV = txtTahunLulusView.getText();
        String ALV = txtAlamatView.getText();
        String IDV = txtIDPencakerView.getText();
        String JKV = cbJenisKelaminView.getSelectedItem().toString();
        String AV = cbAgamaView.getSelectedItem().toString();
        String KWV = cbKewarganegaraanView.getSelectedItem().toString();
        String SV = cbStatusView.getSelectedItem().toString();
        String PTV = cbPendidikanView.getSelectedItem().toString();
        String KKV = cbKecaKeluView.getSelectedItem().toString();
        if ((KTPV.isEmpty()) | (NPV.isEmpty()) |  (TLV.isEmpty())
            | (NSV.isEmpty()) |  (JV.isEmpty()) | (THV.isEmpty()) |  (ALV.isEmpty())
            | (IDV.isEmpty()) |  (JKV.isEmpty()) | (AV.isEmpty()) |  (KWV.isEmpty())
            | (SV.isEmpty())  |  (PTV.isEmpty()) | (KKV.isEmpty()))
        {JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong, "+ "Silahkan Dilengkapi");
            txtNamaPencakerView.requestFocus();
        }else {
            int app;
            if ((app = JOptionPane.showConfirmDialog(null, "Anda Yakin Akan Menghapus Data " + txtIDPencakerView.getText()
                + " ?", "Perhatian", JOptionPane.YES_NO_CANCEL_OPTION)) == 0) {
        try {
            String sql = "delete from pencaker where" + " ID_Pencaker = '" + txtIDPencakerView.getText() + "'";
            conn.query(sql);
            JOptionPane.showMessageDialog(null, txtNamaPencakerView.getText()+ " Berhasil Dihapus");
            TampilPencaker();
            SetEditOffViewPencaker();
            BersihDataViewPencaker();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        }
        }
    }//GEN-LAST:event_btnDeletePencakerViewActionPerformed

    private void btnCancelPencakerViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelPencakerViewActionPerformed
        // TODO add your handling code here:
        BersihDataViewPencaker();
        SetEditOffViewPencaker();
    }//GEN-LAST:event_btnCancelPencakerViewActionPerformed

    private void btnClosePencakerViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosePencakerViewActionPerformed
        // TODO add your handling code here:
        panelViewPencaker.setVisible(false);
    }//GEN-LAST:event_btnClosePencakerViewActionPerformed

    private void txtNoKTPViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoKTPViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKTPViewActionPerformed

    private void txtNoKTPViewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoKTPViewKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKTPViewKeyPressed

    private void txtNoKTPViewKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoKTPViewKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKTPViewKeyReleased

    private void txtNoKTPViewKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoKTPViewKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoKTPViewKeyTyped

    private void txtTahunLulusViewKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTahunLulusViewKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunLulusViewKeyTyped

    private void btnUpdatePencakerViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePencakerViewActionPerformed
        // TODO add your handling code here:
        String KTPV = txtNoKTPView.getText();
        String NPV = txtNamaPencakerView.getText();
        String TLV = txtTempatLahirView.getText();
        String NSV = txtNamaSekolahView.getText();
        String JV = txtJurusanView.getText();
        String THV = txtTahunLulusView.getText();
        String ALV = txtAlamatView.getText();
        String IDV = txtIDPencakerView.getText();
        String JKV = cbJenisKelaminView.getSelectedItem().toString();
        String AV = cbAgamaView.getSelectedItem().toString();
        String KWV = cbKewarganegaraanView.getSelectedItem().toString();
        String SV = cbStatusView.getSelectedItem().toString();
        String PTV = cbPendidikanView.getSelectedItem().toString();
        String KKV = cbKecaKeluView.getSelectedItem().toString();
        if ((KTPV.isEmpty()) | (NPV.isEmpty()) |  (TLV.isEmpty())
            | (NSV.isEmpty()) |  (JV.isEmpty()) | (THV.isEmpty()) |  (ALV.isEmpty())
            | (IDV.isEmpty()) |  (JKV.isEmpty()) | (AV.isEmpty()) |  (KWV.isEmpty())
            | (SV.isEmpty())  |  (PTV.isEmpty()) | (KKV.isEmpty()))
        {JOptionPane.showMessageDialog(null,"Data Tidak Boleh Kosong, "+ "Silahkan Dilengkapi");
            txtNamaPencakerView.requestFocus();
        }else {
            try{
                String tanggalLahirView ="yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(tanggalLahirView);
                String tgllahirview = String.valueOf(fm.format(dtTglLahirView.getDate()));
                String SQL = "update pencaker set" + " No_KTP = '" + txtNoKTPView.getText() + "',"
                + " Nama = '" + txtNamaPencakerView.getText() + "',"
                + " Tempat_Lahir = '" + txtTempatLahirView.getText() + "',"
                + " Tanggal_Lahir = '" + tgllahirview + "',"
                + " Jenis_Kelamin = '" + cbJenisKelaminView.getSelectedItem()+ "',"
                + " Agama = '" + cbAgamaView.getSelectedItem() + "',"
                + " Kewarganegaraan = '" + cbKewarganegaraanView.getSelectedItem()+ "',"
                + " Status = '" + cbStatusView.getSelectedItem() + "',"
                + " Pendidikan_Terakhir = '" + cbPendidikanView.getSelectedItem() + "',"
                + " Nama_Sekolah = '" + txtNamaSekolahView.getText() + "',"
                + " Jurusan = '" + txtJurusanView.getText() + "',"
                + " Tahun_Lulus = '" + txtTahunLulusView.getText() + "',"
                + " Alamat = '" + txtAlamatView.getText() + "',"
                + " Kecamatan_Kelurahan = '" + cbKecaKeluView.getSelectedItem() + "',"
                + " No_Telp = '" + txtNoHpView.getText() + "'where" + " ID_Pencaker = '" + txtIDPencakerView.getText() + "'";
                conn.query(SQL);
                JOptionPane.showMessageDialog(null, txtNamaPencakerView.getText()+ " Berhasil Diubah");
                TampilPencaker();
                SetEditOffViewPencaker();
                BersihDataViewPencaker();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatePencakerViewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HalamanUtamaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtamaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtamaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtamaUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanUtamaUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblDataPencaker;
    private javax.swing.JButton btnCancelPencakerView;
    private javax.swing.JButton btnClosePencakerView;
    private javax.swing.JButton btnDeletePencakerView;
    private javax.swing.JButton btnUpdatePencakerView;
    private javax.swing.JComboBox<String> cbAgamaView;
    private javax.swing.JComboBox<String> cbJenisKelaminView;
    private javax.swing.JComboBox<String> cbKecaKeluView;
    private javax.swing.JComboBox<String> cbKewarganegaraanView;
    private javax.swing.JComboBox<String> cbPendidikanView;
    private javax.swing.JComboBox<String> cbStatusView;
    private com.toedter.calendar.JDateChooser dtTglLahirView;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mInputDataPencaker;
    private javax.swing.JMenuItem mInputIDBaru;
    private javax.swing.JMenuItem mKeluar;
    private javax.swing.JMenuItem mLogout;
    private javax.swing.JMenuItem mViewDaftarID;
    private javax.swing.JMenuItem mViewPencaker;
    private javax.swing.JPanel panelViewPencaker;
    private javax.swing.JTextField txtAlamatView;
    private javax.swing.JTextField txtIDPencakerView;
    private javax.swing.JTextField txtJurusanView;
    private javax.swing.JTextField txtNamaPencakerView;
    private javax.swing.JTextField txtNamaSekolahView;
    private javax.swing.JTextField txtNoHpView;
    private javax.swing.JTextField txtNoKTPView;
    private javax.swing.JTextField txtTahunLulusView;
    private javax.swing.JTextField txtTempatLahirView;
    // End of variables declaration//GEN-END:variables
}

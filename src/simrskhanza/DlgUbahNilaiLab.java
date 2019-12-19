/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgPerawatan.java
 *
 * Created on May 23, 2010, 6:36:30 PM
 */

package simrskhanza;

import fungsi.WarnaTable;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dosen
 */
public final class DlgUbahNilaiLab extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i=0;
    private String tanggal="",jam="";
    

    /** Creates new form DlgPerawatan
     * @param parent
     * @param modal */
    public DlgUbahNilaiLab(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(885,674);

        Object[] row={"Pemeriksaan","Hasil","Satuan","Nilai Rujukan","Keterangan","ID Detail","Kode Periksa"};
        tabMode=new DefaultTableModel(null,row){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                    boolean a = false;
                    if ((colIndex==1)||(colIndex==3)||(colIndex==4)) {
                        a=true;
                    }
                    return a;
             }
             Class[] types = new Class[] {
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }              
        };
        
        tbPemeriksaan.setModel(tabMode);
        //tampilPr();

        tbPemeriksaan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPemeriksaan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 7; i++) {
            TableColumn column = tbPemeriksaan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(230);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(70);
            }else if(i==3){
                column.setPreferredWidth(130);
            }else if(i==4){
                column.setPreferredWidth(130);
            }else if(i==5){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==6){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        
        tbPemeriksaan.setDefaultRenderer(Object.class, new WarnaTable());
        
        jam();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        jLabel10 = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass11 = new widget.panelisi();
        jLabel3 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        Tanggal = new widget.Tanggal();
        jLabel15 = new widget.Label();
        jLabel16 = new widget.Label();
        CmbJam = new widget.ComboBox();
        CmbMenit = new widget.ComboBox();
        CmbDetik = new widget.ComboBox();
        ChkJln = new widget.CekBox();
        Scroll = new widget.ScrollPane();
        tbPemeriksaan = new widget.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Ubah Nilai Hasil Laboratorium ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(400, 30));
        panelGlass8.add(jLabel10);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        internalFrame1.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        panelGlass11.setName("panelGlass11"); // NOI18N
        panelGlass11.setPreferredSize(new java.awt.Dimension(44, 73));
        panelGlass11.setLayout(null);

        jLabel3.setText("No.Rawat :");
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass11.add(jLabel3);
        jLabel3.setBounds(0, 10, 70, 23);

        TNoRw.setEditable(false);
        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.setPreferredSize(new java.awt.Dimension(130, 23));
        panelGlass11.add(TNoRw);
        TNoRw.setBounds(74, 10, 130, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.setPreferredSize(new java.awt.Dimension(100, 23));
        panelGlass11.add(TNoRM);
        TNoRM.setBounds(207, 10, 100, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        TPasien.setPreferredSize(new java.awt.Dimension(290, 23));
        panelGlass11.add(TPasien);
        TPasien.setBounds(310, 10, 300, 23);

        Tanggal.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30-11-2019" }));
        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setOpaque(false);
        panelGlass11.add(Tanggal);
        Tanggal.setBounds(180, 40, 100, 23);

        jLabel15.setText("Tanggal Keluar Hasil :");
        jLabel15.setName("jLabel15"); // NOI18N
        panelGlass11.add(jLabel15);
        jLabel15.setBounds(10, 40, 166, 23);

        jLabel16.setText("Jam Keluar Hasil :");
        jLabel16.setName("jLabel16"); // NOI18N
        panelGlass11.add(jLabel16);
        jLabel16.setBounds(285, 40, 100, 23);

        CmbJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        CmbJam.setName("CmbJam"); // NOI18N
        panelGlass11.add(CmbJam);
        CmbJam.setBounds(389, 40, 62, 23);

        CmbMenit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        CmbMenit.setName("CmbMenit"); // NOI18N
        panelGlass11.add(CmbMenit);
        CmbMenit.setBounds(455, 40, 62, 23);

        CmbDetik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        CmbDetik.setName("CmbDetik"); // NOI18N
        panelGlass11.add(CmbDetik);
        CmbDetik.setBounds(521, 40, 62, 23);

        ChkJln.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(195, 215, 195)));
        ChkJln.setSelected(true);
        ChkJln.setBorderPainted(true);
        ChkJln.setBorderPaintedFlat(true);
        ChkJln.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkJln.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkJln.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkJln.setName("ChkJln"); // NOI18N
        ChkJln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkJlnActionPerformed(evt);
            }
        });
        panelGlass11.add(ChkJln);
        ChkJln.setBounds(587, 40, 23, 23);

        internalFrame1.add(panelGlass11, java.awt.BorderLayout.PAGE_START);

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbPemeriksaan.setName("tbPemeriksaan"); // NOI18N
        Scroll.setViewportView(tbPemeriksaan);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        ChkJln.setSelected(false);
        for(i=0;i<tbPemeriksaan.getRowCount();i++){ 
            Sequel.mengedit("detail_periksa_lab","no_rawat=? and kd_jenis_prw=? and tgl_periksa=? and jam=? and id_template=?","nilai=?,nilai_rujukan=?,keterangan=?,tgl_periksa=?,jam=?",10,new String[]{
                tbPemeriksaan.getValueAt(i,1).toString(),tbPemeriksaan.getValueAt(i,3).toString(),tbPemeriksaan.getValueAt(i,4).toString(),Valid.SetTgl(Tanggal.getSelectedItem()+""),
                CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem()+":"+CmbDetik.getSelectedItem(),TNoRw.getText(),tbPemeriksaan.getValueAt(i,6).toString(),tanggal,jam,tbPemeriksaan.getValueAt(i,5).toString()
            });
        }
        
        Sequel.mengedit("periksa_lab","no_rawat=? and tgl_periksa=? and jam=?","tgl_periksa=?,jam=?",5,new String[]{
            Valid.SetTgl(Tanggal.getSelectedItem()+""),CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem()+":"+CmbDetik.getSelectedItem(),TNoRw.getText(),tanggal,jam
        });
        
        Sequel.mengedit("permintaan_lab","no_rawat=? and tgl_hasil=? and jam_hasil=?","tgl_hasil=?,jam_hasil=?",5,new String[]{
            Valid.SetTgl(Tanggal.getSelectedItem()+""),CmbJam.getSelectedItem()+":"+CmbMenit.getSelectedItem()+":"+CmbDetik.getSelectedItem(),TNoRw.getText(),tanggal,jam
        });
        JOptionPane.showMessageDialog(null,"Proses update hasil pemeriksaan sudah selesai !!!");
        dispose();
        ChkJln.setSelected(true);
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
               //Valid.pindah(evt,Pemeriksaan,BtnHapus);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnSimpan,TNoRw);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void ChkJlnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkJlnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkJlnActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgUbahNilaiLab dialog = new DlgUbahNilaiLab(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkJln;
    private widget.ComboBox CmbDetik;
    private widget.ComboBox CmbJam;
    private widget.ComboBox CmbMenit;
    private widget.ScrollPane Scroll;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.Tanggal Tanggal;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel3;
    private widget.panelisi panelGlass11;
    private widget.panelisi panelGlass8;
    private widget.Table tbPemeriksaan;
    // End of variables declaration//GEN-END:variables

    public void setNoRm(String norwt,String tanggal,String jam) {        
        try {
            TNoRw.setText(norwt);
            Sequel.cariIsi("select no_rkm_medis from reg_periksa where no_rawat=? ",TNoRM,TNoRw.getText());
            Sequel.cariIsi("select nm_pasien from pasien where no_rkm_medis=? ",TPasien,TNoRM.getText());
            this.tanggal=tanggal;
            this.jam=jam;
            ps=koneksi.prepareStatement(
                    "select detail_periksa_lab.id_template,template_laboratorium.Pemeriksaan, detail_periksa_lab.nilai,template_laboratorium.satuan,detail_periksa_lab.nilai_rujukan,"+
                    "detail_periksa_lab.keterangan,detail_periksa_lab.kd_jenis_prw "+
                    "from detail_periksa_lab inner join template_laboratorium on detail_periksa_lab.id_template=template_laboratorium.id_template "+
                    "where detail_periksa_lab.no_rawat=? and detail_periksa_lab.tgl_periksa=? and detail_periksa_lab.jam=?");
            try {
                ps.setString(1,TNoRw.getText());
                ps.setString(2,tanggal);
                ps.setString(3,jam);
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                         "   "+rs.getString("Pemeriksaan"),rs.getString("nilai"),rs.getString("satuan"),
                        rs.getString("nilai_rujukan"),"",rs.getString("id_template"),rs.getString("kd_jenis_prw")
                    });
                } 
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }         
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(akses.getperiksa_lab());
    }
    
    private void jam(){
        ActionListener taskPerformer = new ActionListener(){
            private int nilai_jam;
            private int nilai_menit;
            private int nilai_detik;
            @Override
            public void actionPerformed(ActionEvent e) {
                String nol_jam = "";
                String nol_menit = "";
                String nol_detik = "";
                // Membuat Date
                //Date dt = new Date();
                Date now = Calendar.getInstance().getTime();

                // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
                if(ChkJln.isSelected()==true){
                    nilai_jam = now.getHours();
                    nilai_menit = now.getMinutes();
                    nilai_detik = now.getSeconds();
                }else if(ChkJln.isSelected()==false){
                    nilai_jam =CmbJam.getSelectedIndex();
                    nilai_menit =CmbMenit.getSelectedIndex();
                    nilai_detik =CmbDetik.getSelectedIndex();
                }

                // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
                if (nilai_jam <= 9) {
                    // Tambahkan "0" didepannya
                    nol_jam = "0";
                }
                // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
                if (nilai_menit <= 9) {
                    // Tambahkan "0" didepannya
                    nol_menit = "0";
                }
                // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
                if (nilai_detik <= 9) {
                    // Tambahkan "0" didepannya
                    nol_detik = "0";
                }
                // Membuat String JAM, MENIT, DETIK
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                // Menampilkan pada Layar
                //tampil_jam.setText("  " + jam + " : " + menit + " : " + detik + "  ");
                CmbJam.setSelectedItem(jam);
                CmbMenit.setSelectedItem(menit);
                CmbDetik.setSelectedItem(detik);
            }
        };
        // Timer
        new Timer(1000, taskPerformer).start();
    }

}

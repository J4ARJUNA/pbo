/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pelanggan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import juna_pbo.koneksi;
/**
 *
 * @author Arjuna
 */
public class fpelanggan extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    
    DefaultTableModel tabMode;
    public fpelanggan(){
        initComponents();
        String[]row = {"kdpelanggan","nama","jenis_kelamin","alamat","telp"};
        tabMode = new DefaultTableModel(null,row);
        
        TabelViewData.setModel(tabMode);
        
        kosong();
        tampilTabel();
    }
    
    public void kosong(){
        clsPelanggan plg = new clsPelanggan();
        txtKode.setText("");
        txtKode.setEnabled(false);
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelp.setText("");
        
        txtKode.requestFocus();
        btnSimpan.setEnabled(true);
        
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        plg.autoKode();
        txtKode.setText(plg.getKodep());
    }
    
    public void tampilTabel(){
        String kdp,nmp,jkp, alp,  tlp;
        int baris=tabMode.getRowCount();
        
        for(int i=0;i<baris;i++)
        {
            tabMode.removeRow(0);
        }
        try
        {
            koneksi k = new koneksi();
            Connection cn =  k.openKoneksi();
            Statement st = cn.createStatement();
            String sql ="select * from tabelpelanggan order by kdpelanggan asc";
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                kdp=rs.getString("kdpelanggan");
                nmp=rs.getString("nama");
                jkp=rs.getString("jenis_kelamin");
                alp=rs.getString("alamat");
                tlp=rs.getString("telp");
                String [] data={kdp,nmp,jkp,alp,tlp};
                tabMode.addRow(data);
            }
            rs.close();
            st.close();
        }
        catch(SQLException sqe){}
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        Bperempuan = new javax.swing.JRadioButton();
        Blaki = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelViewData = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnKeluar = new javax.swing.JButton();
        txtAlamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bPerempuan = new javax.swing.JRadioButton();
        bLaki = new javax.swing.JRadioButton();

        jLabel7.setText("Gender");

        Bperempuan.setText("Perempuan");
        Bperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BperempuanActionPerformed(evt);
            }
        });

        Blaki.setText("Laki - laki");
        Blaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlakiActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Alamat");

        txtTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelpActionPerformed(evt);
            }
        });

        jLabel6.setText("Telp");

        TabelViewData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelViewData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelViewDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelViewData);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("EDIT");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ENTRY DATA PELANGGAN");

        jLabel2.setText("Kode Pelanggan");

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Pelanggan");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });

        jLabel8.setText("Gender");

        buttonGroup1.add(bPerempuan);
        bPerempuan.setText("Perempuan");
        bPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPerempuanActionPerformed(evt);
            }
        });

        buttonGroup1.add(bLaki);
        bLaki.setText("Laki - laki");
        bLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLakiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtNama)
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtTelp)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLaki)
                    .addComponent(bPerempuan)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(18, 18, 18)
                .addComponent(btnKeluar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelpActionPerformed

    private void TabelViewDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelViewDataMouseClicked
        int tabelData = TabelViewData.getSelectedRow();

        txtKode.setText(""+TabelViewData.getValueAt(tabelData, 0));
        txtNama.setText(""+TabelViewData.getValueAt(tabelData, 1));
        String JenisKelamin = ""+ TabelViewData.getValueAt(tabelData, 2);
        if(JenisKelamin.equalsIgnoreCase("laki-laki")){
            bLaki.setSelected(true);
            bPerempuan.setSelected(false);
        }else if(JenisKelamin.equalsIgnoreCase("perempuan")){
            bLaki.setSelected(false);
            bPerempuan.setSelected(true);
        }
        txtAlamat.setText(""+TabelViewData.getValueAt(tabelData, 3));
        txtTelp.setText(""+TabelViewData.getValueAt(tabelData, 4));
        txtNama.requestFocus();
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_TabelViewDataMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String JenisKelamin = "";
        clsPelanggan plg = new clsPelanggan();
        plg.setKodep(txtKode.getText());
        plg.setNamap(txtNama.getText());
        if (bLaki.isSelected()){
            JenisKelamin = bLaki.getText();
        } else if (bPerempuan.isSelected()){
            JenisKelamin = bPerempuan.getText();
        }
        plg.setJkp(JenisKelamin);
        plg.setAlamatp(txtAlamat.getText());
        plg.setTlpp(txtTelp.getText());
        plg.simpan();
        if(plg.getFlag()==1)
        {
            kosong();
            tampilTabel();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
         String JenisKelamin = "";
        
        clsPelanggan plg = new clsPelanggan();
        plg.setKodep(txtKode.getText());
        plg.setNamap(txtNama.getText());
        if (bLaki.isSelected()){
            JenisKelamin = bLaki.getText();
        } else if (bPerempuan.isSelected()){
            JenisKelamin = bPerempuan.getText();
        }
        plg.setJkp(JenisKelamin);
        plg.setAlamatp(txtAlamat.getText());
        plg.setTlpp(txtTelp.getText());
        plg.ubah();

        if(plg.getFlag()==2)
        {
            kosong();
            tampilTabel();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        clsPelanggan plg = new clsPelanggan();
        plg.setKodep(txtKode.getText());
        plg.hapus();

        if(plg.getFlag()==3)
        {
            kosong();
            tampilTabel();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
        tampilTabel();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        clsPelanggan plg = new clsPelanggan();
        plg.setKodep(txtKode.getText());
        plg.tampil();
        String jenis_kelamin;
        if (bLaki.isSelected()) {
            jenis_kelamin = "Laki-laki";
        } else {
            jenis_kelamin = "Perempuan";
        }
        plg.setJkp(jenis_kelamin);
        if(plg.getFlag()==4){
            plg.setKodep(txtKode.getText());
            plg.setNamap(txtNama.getText());
            plg.setJkp(jenis_kelamin);
            plg.setAlamatp(txtAlamat.getText());
            plg.setTlpp(txtTelp.getText());
            txtNama.requestFocus();
            btnSimpan.setEnabled(false);
            btnUbah.setEnabled(true);
            btnHapus.setEnabled(true);
        }else{
            plg.setKodep(txtKode.getText());
            plg.setNamap(txtNama.getText());
            plg.setJkp(jenis_kelamin);
            plg.setAlamatp(txtAlamat.getText());
            plg.setTlpp(txtTelp.getText());
            txtNama.requestFocus();
            btnSimpan.setEnabled(true);
            btnUbah.setEnabled(false);
            btnHapus.setEnabled(false);
        }
    }//GEN-LAST:event_txtKodeActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void BperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BperempuanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BperempuanActionPerformed

    private void BlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BlakiActionPerformed

    private void bPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPerempuanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bPerempuanActionPerformed

    private void bLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLakiActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

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
            java.util.logging.Logger.getLogger(fpelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fpelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fpelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fpelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fpelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Blaki;
    private javax.swing.JRadioButton Bperempuan;
    private javax.swing.JTable TabelViewData;
    private javax.swing.JRadioButton bLaki;
    private javax.swing.JRadioButton bPerempuan;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}

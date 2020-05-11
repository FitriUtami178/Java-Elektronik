/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msi
 */
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Kategori extends javax.swing.JFrame {
private DefaultTableModel model;
    /**
     * Creates new form Kategori
     */
    public Kategori() {
        initComponents();
         setLocationRelativeTo(this);
        model = new DefaultTableModel();

        tabelinput.setModel(model);

        model.addColumn("kd_barang");
        model.addColumn("kategori_barang");
        loadData();
        kode();
    }
    
     public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
     
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    
    public final void loadData() {
        bsimpan.setEnabled(true);
        bhapus.setEnabled(false);
        bedit.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM kt_barang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[2];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("kategori_barang");                
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
     private void kode() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM kt_barang ORDER by kd_barang desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("kd_barang").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                tkdbarang.setText("B" + Nol + AN);
            } else {
                tkdbarang.setText("B0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tkdbarang = new javax.swing.JTextField();
        tkategoribarang = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();
        tcari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CARI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kategori Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        tkdbarang.setEditable(false);
        tkdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkdbarangActionPerformed(evt);
            }
        });
        jPanel1.add(tkdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 230, 30));

        tkategoribarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tkategoribarangKeyTyped(evt);
            }
        });
        jPanel1.add(tkategoribarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 230, 30));

        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 90, 30));

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 90, 30));

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel1.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 90, 30));

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelinput);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 770, 180));

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });
        jPanel1.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 270, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Chaparral Pro Light", 1, 24)); // NOI18N
        jLabel1.setText("Input Kategori Barang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        exit.setText("KEMBALI");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel2.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkdbarangActionPerformed

    private void tkategoribarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tkategoribarangKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_tkategoribarangKeyTyped

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if(tkdbarang.getText().equals("") ||tkategoribarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !");
        }else{
            int i = tabelinput.getSelectedRow();
            if (i == -1) {
                return;
            }
            String user = (String) model.getValueAt(i, 0);
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE  kt_barang SET kategori_barang =  '" + tkategoribarang.getText()+"' WHERE  kd_barang ='" + tkdbarang.getText() + "'";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                tkdbarang.setText("");
                tkategoribarang.setText("");
                bsimpan.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            }
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        if(tkdbarang.getText().equals("") ||tkategoribarang.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !");
        }else{
            String kbarang = tkdbarang.getText();
            String nbarang = tkategoribarang.getText();

            try {
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                System.out.println(date);
                String tgl = date.toString();
                Connection c = koneksi.getKoneksi();

                String sql = "INSERT INTO kt_barang VALUES (?, ?)";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kbarang);
                p.setString(2, nbarang);

                p.executeUpdate();
                p.close();

            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                kode();

                tkategoribarang.setText("");


                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan");
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from kt_barang where kd_barang='"+tkdbarang.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        tkdbarang.setText("");
        tkategoribarang.setText("");
    }//GEN-LAST:event_bhapusActionPerformed

    private void tabelinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinputMouseClicked
        // TODO add your handling code here:
        bsimpan.setEnabled(false);
        bedit.setEnabled(true);
        bhapus.setEnabled(true);
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kbarang = (String) model.getValueAt(i, 0);
        tkdbarang.setText(kbarang);
        tkdbarang.setEnabled(false);

        String nbarang = (String) model.getValueAt(i, 1);
        tkategoribarang.setText(nbarang);

    }//GEN-LAST:event_tabelinputMouseClicked

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        MenuAdmin ma = new MenuAdmin();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Kategori kt = new Kategori();
        kt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            String sql = "select * from kt_barang where kategori_barang =?";
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            PreparedStatement pst= c.prepareStatement(sql);   
            pst.setString(1, tcari.getText());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Object[] o = new Object[2];
                o[0] = rs.getString("kd_barang");
                o[1] = rs.getString("kategori_barang");

                model.addRow(o);
                
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error" +e);
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

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
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelinput;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkategoribarang;
    private javax.swing.JTextField tkdbarang;
    // End of variables declaration//GEN-END:variables
}
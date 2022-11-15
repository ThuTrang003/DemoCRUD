/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodels.LopHoc;
import domainmodels.SinhVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.LopHocServiceImpl;
import service.impl.SinhVienServiecImpl;
import viewmodels.LopHocViewModel;
import viewmodels.SinhVienViewModel;

/**
 *
 * @author ADMIN
 */
public class SinhVienViews extends javax.swing.JFrame {

    private SinhVienServiecImpl svSv;
    private LopHocServiceImpl lhSv;
    List<SinhVienViewModel> lst = new ArrayList<>();
    public SinhVienViews() {
        initComponents();
        this.svSv = new SinhVienServiecImpl();
        this.lhSv = new LopHocServiceImpl();
        this.loadCbb();
        this.loadTable();
    }

    public void loadCbb() {
        List<LopHocViewModel> lstNSX = this.lhSv.getList();
        for (LopHocViewModel x : lstNSX) {
            cbbLop.addItem(x);
        }
    }
    
    public void loadTable(){
        lst = this.svSv.getList();
        DefaultTableModel dtm = (DefaultTableModel) this.tblSinhVien.getModel();
        dtm.setRowCount(0);
        for (SinhVienViewModel x : lst) {
            dtm.addRow(x.toDataRow());
        }
    }
    
    public void clearForm(){
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.cbbLop.setSelectedIndex(0);
    }

    private SinhVien getFormData(){
        String ma = this.txtMa.getText().trim();
        String ten = this.txtTen.getText().trim();
        LopHocViewModel lop = (LopHocViewModel) this.cbbLop.getSelectedItem();
        
        if (ma.length() == 0 || ten.length() ==0) {
            JOptionPane.showMessageDialog(this, "Các trường thông tin không được để trống");
            return null;
        }
        
        LopHoc lopHoc = new LopHoc(lop.getId(), lop.getMa(), lop.getTen());
        SinhVien sv = new SinhVien();
        sv.setMa(ma);
        sv.setTen(ten);
        sv.setLopHoc(lopHoc);
        return sv;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tbnThem = new javax.swing.JButton();
        tbnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        cbbLop = new javax.swing.JComboBox<LopHocViewModel>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã SV:");

        jLabel2.setText("Tên SV:");

        jLabel3.setText("Lớp");

        tbnThem.setText("Thêm");
        tbnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemActionPerformed(evt);
            }
        });

        tbnSua.setText("Sửa");
        tbnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Tên SV", "Mã lớp", "Tên lớp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        cbbLop.setModel(new javax.swing.DefaultComboBoxModel<LopHocViewModel>());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(37, 37, 37)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(cbbLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbnThem)
                        .addGap(64, 64, 64)
                        .addComponent(tbnSua)
                        .addGap(69, 69, 69)
                        .addComponent(btnXoa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnThem)
                    .addComponent(tbnSua)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        int row = this.tblSinhVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn một dòng trên table");
            return;
        }
        String ma = this.tblSinhVien.getValueAt(row, 0).toString();
        String ten = this.tblSinhVien.getValueAt(row, 1).toString();
        String maLop = this.tblSinhVien.getValueAt(row, 2).toString();
        
        this.txtMa.setText(ma);
        this.txtTen.setText(ten);
        
        LopHoc lopHoc = this.lhSv.findByMa(maLop);
        LopHocViewModel hocViewModel = new LopHocViewModel(lopHoc.getId(), lopHoc.getMa(), lopHoc.getTen());
        this.cbbLop.setSelectedItem(hocViewModel);
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void tbnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemActionPerformed
        // TODO add your handling code here:
        SinhVien sv = getFormData();
        if (sv == null) {
            return;
        }
        
        this.svSv.insert(sv);
        this.loadTable();
        this.clearForm();
    }//GEN-LAST:event_tbnThemActionPerformed

    private void tbnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblSinhVien.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Bạn cần chọn một dòng trên table");
                return;
            }
            if (txtMa.getText().trim().length() > 10) {
                JOptionPane.showMessageDialog(this, "Mã tối đa 10 kí tự");
                return;
            }
            SinhVien sv = this.getFormData();
            sv.setId(lst.get(index).getId());
            String message = svSv.update(sv);
            loadTable();
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = this.tblSinhVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn một dòng trên table");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này không");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        String ma = this.tblSinhVien.getValueAt(row, 0).toString();
        SinhVien sinhVien = svSv.findByMa(ma);
        String message = this.svSv.delete(sinhVien);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(SinhVienViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinhVienViews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<LopHocViewModel> cbbLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JButton tbnSua;
    private javax.swing.JButton tbnThem;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}

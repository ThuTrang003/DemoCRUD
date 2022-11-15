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
import viewmodels.SinhVienView;
import viewmodels.SinhVienViewModel;

/**
 *
 * @author ADMIN
 */
public class TestJFrame extends javax.swing.JFrame {

    private final DefaultTableModel modelSInhVienAdd;
    private final DefaultTableModel modelAllSInhVien;
    private LopHocServiceImpl lhSv;
    private SinhVienServiecImpl svSv;
    List<SinhVienView> lst = new ArrayList<>();
    List<SinhVienView> lst1 = new ArrayList<>();

    public TestJFrame() {
        initComponents();
        svSv = new SinhVienServiecImpl();
        lhSv = new LopHocServiceImpl();
        modelAllSInhVien = (DefaultTableModel) this.tblAllSinhVien.getModel();
        modelSInhVienAdd = (DefaultTableModel) this.tblSinhVienAdd.getModel();
        this.loadCbb();
        this.loadTable();
    }

    public void loadCbb() {
        List<LopHocViewModel> lstNSX = this.lhSv.getList();
        for (LopHocViewModel x : lstNSX) {
            cbbLop.addItem(x);
        }
    }

    public void loadTable() {
        lst = this.svSv.getAll();
        DefaultTableModel dtm = (DefaultTableModel) this.tblAllSinhVien.getModel();
        dtm.setRowCount(0);
        for (SinhVienView x : lst) {
            dtm.addRow(x.toDataRow());
        }
    }

    public void clearForm() {
        this.txtMa.setText("");
        this.txtTen.setText("");
        this.cbbLop.setSelectedIndex(0);
    }

    private SinhVien getFormData() {
        String ma = this.txtMa.getText().trim();
        String ten = this.txtTen.getText().trim();

        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Các trường thông tin không được để trống");
            return null;
        }

        SinhVien sv = new SinhVien();
        sv.setMa(ma);
        sv.setTen(ten);
        return sv;
    }

    public void loadDataSinhVien() {
        modelSInhVienAdd.setRowCount(0);
        for (SinhVienView x : lst1) {
            modelSInhVienAdd.addRow(x.toDataRow());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        cbbLop = new javax.swing.JComboBox<LopHocViewModel>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVienAdd = new javax.swing.JTable();
        btnAddAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllSinhVien = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        cbbLop.setModel(new javax.swing.DefaultComboBoxModel<LopHocViewModel>());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách sinh viên cần thêm");

        tblSinhVienAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSinhVienAdd);

        btnAddAll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddAll.setText("Thêm tất cả");
        btnAddAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAllActionPerformed(evt);
            }
        });

        tblAllSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã", "Tên"
            }
        ));
        tblAllSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAllSinhVien);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tất cả sinh viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(37, 37, 37)
                                .addComponent(btnSua)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(279, 279, 279)
                                .addComponent(btnAddAll))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAllSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllSinhVienMouseClicked
        // TODO add your handling code here:
        int row = tblAllSinhVien.getSelectedRow();
        tblAllSinhVien.clearSelection();
        SinhVienView sinhVienView = lst.get(row);
        for (SinhVienView x : lst1) {
            if (x.getId() == sinhVienView.getId()) {
                JOptionPane.showMessageDialog(this, "Sinh viên này đã tồn tại trong danh sách cần thêm!");
                return;
            }
        }
        lst1.add(sinhVienView);
        this.loadDataSinhVien();
    }//GEN-LAST:event_tblAllSinhVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            SinhVien sv = getFormData();
            if (sv == null) {
                return;
            }

            String message = svSv.insert(sv);
            this.loadTable();
            this.clearForm();
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            int index = tblAllSinhVien.getSelectedRow();
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
            this.clearForm();
            JOptionPane.showMessageDialog(this, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnAddAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAllActionPerformed
        // TODO add your handling code here:
        if (lst1.size() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn sinh viên để thêm");
            return;
        }
        LopHocViewModel lop = (LopHocViewModel) this.cbbLop.getSelectedItem();
        LopHoc lopHoc = new LopHoc(lop.getId(), lop.getMa(), lop.getTen());
        for (SinhVienView x : lst1) {
            SinhVien sv = new SinhVien();
            sv.setId(x.getId());
            sv.setMa(x.getMa());
            sv.setTen(x.getTen());
            sv.setLopHoc(lopHoc);
            this.svSv.update(sv);
            
        }
        lst1.clear();
        this.loadDataSinhVien();
        JOptionPane.showMessageDialog(this, "Thêm lớp thành công");
    }//GEN-LAST:event_btnAddAllActionPerformed

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
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAll;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<LopHocViewModel> cbbLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblAllSinhVien;
    private javax.swing.JTable tblSinhVienAdd;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}

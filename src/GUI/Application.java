package GUI;
import java.awt.event.ActionEvent;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author trita
 */
public class Application extends javax.swing.JFrame {
    private JPanel childPanel;
    private ActionEvent evt;

    /**
     * Creates new form Application
     */
    public Application() {
        initComponents();
        jButton_DashboardActionPerformed(evt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Change = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel_MainMenu = new javax.swing.JPanel();
        jButton_Dashboard = new javax.swing.JButton();
        jButton_DoanhThu = new javax.swing.JButton();
        jButton_HoaDon = new javax.swing.JButton();
        jButton_NhanVien = new javax.swing.JButton();
        jButton_BangLuong = new javax.swing.JButton();
        jButton_KhachHang = new javax.swing.JButton();
        jButton_Kho = new javax.swing.JButton();
        jButton_CuaHang = new javax.swing.JButton();
        jButton_NhaCungCap = new javax.swing.JButton();
        jButton_HoaDonChiTra = new javax.swing.JButton();
        jButton_DangXuat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ CỬA HÀNG THỜI TRANG");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Change.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel_Change.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel_Change.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel_Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 6, 1260, 760));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 10, -1, 766));

        jScrollPane2.setBackground(new java.awt.Color(102, 204, 255));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel_MainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Dashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_dashboard_100px.png"))); // NOI18N
        jButton_Dashboard.setText("Dashboard");
        jButton_Dashboard.setToolTipText("Dashboard");
        jButton_Dashboard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_Dashboard.setIconTextGap(1);
        jButton_Dashboard.setInheritsPopupMenu(true);
        jButton_Dashboard.setPreferredSize(new java.awt.Dimension(172, 72));
        jButton_Dashboard.setVerifyInputWhenFocusTarget(false);
        jButton_Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DashboardActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 227, -1));

        jButton_DoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_DoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_increase_100px.png"))); // NOI18N
        jButton_DoanhThu.setText("Doanh thu");
        jButton_DoanhThu.setToolTipText("Doanh thu");
        jButton_DoanhThu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_DoanhThu.setIconTextGap(5);
        jButton_DoanhThu.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton_DoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DoanhThuActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_DoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 84, 227, 71));

        jButton_HoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_bill_100px.png"))); // NOI18N
        jButton_HoaDon.setText("Hóa Đơn");
        jButton_HoaDon.setToolTipText("Hóa Đơn");
        jButton_HoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_HoaDon.setIconTextGap(15);
        jButton_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HoaDonActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_HoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 167, 227, 73));

        jButton_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_collaborator_female_80px.png"))); // NOI18N
        jButton_NhanVien.setText("Nhân Viên");
        jButton_NhanVien.setToolTipText("Nhân Viên");
        jButton_NhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_NhanVien.setIconTextGap(15);
        jButton_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhanVienActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_NhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 252, 227, 70));

        jButton_BangLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_BangLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_payroll_80px.png"))); // NOI18N
        jButton_BangLuong.setText("Bảng Lương");
        jButton_BangLuong.setToolTipText("Bảng Lương");
        jButton_BangLuong.setIconTextGap(5);
        jButton_BangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BangLuongActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_BangLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 338, 227, 73));

        jButton_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_vip_64px.png"))); // NOI18N
        jButton_KhachHang.setText("Khách Hàng");
        jButton_KhachHang.setToolTipText("Khách Hàng");
        jButton_KhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_KhachHang.setIconTextGap(10);
        jButton_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KhachHangActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 423, 227, 70));

        jButton_Kho.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_Kho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_warehouse_100px.png"))); // NOI18N
        jButton_Kho.setText("Kho Hàng");
        jButton_Kho.setToolTipText("Kho Hàng");
        jButton_Kho.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_Kho.setIconTextGap(5);
        jButton_Kho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KhoActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_Kho, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 505, 227, 70));

        jButton_CuaHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_CuaHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_store_front_100px.png"))); // NOI18N
        jButton_CuaHang.setText("Cửa Hàng");
        jButton_CuaHang.setToolTipText("Cửa Hàng");
        jButton_CuaHang.setIconTextGap(5);
        jButton_CuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CuaHangActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_CuaHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 587, 227, 67));

        jButton_NhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_NhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_factory_100px.png"))); // NOI18N
        jButton_NhaCungCap.setText("Nhà Cung");
        jButton_NhaCungCap.setToolTipText("Nhà Cung");
        jButton_NhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_NhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_NhaCungCap.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_NhaCungCap.setIconTextGap(1);
        jButton_NhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NhaCungCapActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_NhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 666, 227, 69));

        jButton_HoaDonChiTra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_HoaDonChiTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_invoice_100px.png"))); // NOI18N
        jButton_HoaDonChiTra.setText("Hóa đơn chi trả");
        jButton_HoaDonChiTra.setToolTipText("Hóa đơn chi trả");
        jButton_HoaDonChiTra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_HoaDonChiTra.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_HoaDonChiTra.setIconTextGap(5);
        jButton_HoaDonChiTra.setInheritsPopupMenu(true);
        jButton_HoaDonChiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HoaDonChiTraActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_HoaDonChiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 747, 227, 72));

        jButton_DangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_shutdown_100px.png"))); // NOI18N
        jButton_DangXuat.setText("Đăng xuất");
        jButton_DangXuat.setToolTipText("Đăng xuất");
        jButton_DangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_DangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton_DangXuat.setIconTextGap(1);
        jButton_DangXuat.setMinimumSize(new java.awt.Dimension(233, 70));
        jButton_DangXuat.setPreferredSize(new java.awt.Dimension(233, 70));
        jButton_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DangXuatActionPerformed(evt);
            }
        });
        jPanel_MainMenu.add(jButton_DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 830, 220, 70));

        jScrollPane2.setViewportView(jPanel_MainMenu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 6, 260, 770));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CuaHangActionPerformed
        childPanel = new Panel_Cua_Hang();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_CuaHangActionPerformed

    private void jButton_KhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KhoActionPerformed
        childPanel = new Panel_Kho();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_KhoActionPerformed

    private void jButton_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KhachHangActionPerformed
        childPanel = new Panel_Khach_Hang();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_KhachHangActionPerformed

    private void jButton_BangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BangLuongActionPerformed
        childPanel = new Panel_Bang_Luong();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_BangLuongActionPerformed

    private void jButton_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhanVienActionPerformed
        childPanel = new Panel_Nhan_Vien();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_NhanVienActionPerformed

    private void jButton_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HoaDonActionPerformed
        childPanel = new Panel_Hoa_Don();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_HoaDonActionPerformed

    private void jButton_DoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DoanhThuActionPerformed
        childPanel = new Panel_Doanh_Thu();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_DoanhThuActionPerformed

    private void jButton_DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DashboardActionPerformed
        childPanel = new Panel_Dashboard();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_DashboardActionPerformed

    private void jButton_NhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NhaCungCapActionPerformed
        childPanel = new Panel_Nha_Cung_Cap();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_NhaCungCapActionPerformed

    private void jButton_HoaDonChiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HoaDonChiTraActionPerformed
        childPanel = new Panel_Hoa_Don_Chi_Tra();
        jPanel_Change.removeAll();
        jPanel_Change.add(childPanel);
        jPanel_Change.validate();
    }//GEN-LAST:event_jButton_HoaDonChiTraActionPerformed

    private void jButton_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DangXuatActionPerformed
        int a = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn đăng xuất");
        if(a==JOptionPane.YES_OPTION){
            Frame_DangNhap dn = new Frame_DangNhap();
        dn.setVisible(true);
        this.dispose();
        }    
    }//GEN-LAST:event_jButton_DangXuatActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BangLuong;
    private javax.swing.JButton jButton_CuaHang;
    private javax.swing.JButton jButton_DangXuat;
    private javax.swing.JButton jButton_Dashboard;
    private javax.swing.JButton jButton_DoanhThu;
    private javax.swing.JButton jButton_HoaDon;
    private javax.swing.JButton jButton_HoaDonChiTra;
    private javax.swing.JButton jButton_KhachHang;
    private javax.swing.JButton jButton_Kho;
    private javax.swing.JButton jButton_NhaCungCap;
    private javax.swing.JButton jButton_NhanVien;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel_Change;
    private javax.swing.JPanel jPanel_MainMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
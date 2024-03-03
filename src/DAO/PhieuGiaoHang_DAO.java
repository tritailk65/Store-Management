/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhieuGiaoHang_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuGiaoHang_DAO {
    private Connection con;
    
    public boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://TRI-TAI\\SQLEXPRESS:1433;databasename=QUAN_LY_CUA_HANG_BAN_QUAN_AO;trustServerCertificate=true";
            String username = "sa";
            String password = "doanjava";
            con = DriverManager.getConnection(dbUrl,username,password);
            return true;
        } catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public void closeConnection(){
        try {
            if(con!=null)
                con.close();
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<PhieuGiaoHang_DTO> getAllPhieuGiaoHang(){
        ArrayList<PhieuGiaoHang_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = """
                             SELECT PG.ID_PHIEUGIAO, PG.ID_PHIEUDAT, PG.IDNV_KIEMTRA, CH.ID_CUAHANG, PG.ID_NHACUNG, PD.NGAYDAT, PG.NGAYGIAO, SUM(CTPG.SOLUONG*SP.GIA)
                             FROM PHIEU_DAT_HANG PD, PHIEU_GIAO_HANG PG, CHI_TIET_PHIEU_GIAO CTPG, SAN_PHAM SP, NHAN_VIEN NV, CUA_HANG CH
                             WHERE PD.ID_PHIEUDAT = PG.ID_PHIEUDAT AND PG.ID_PHIEUGIAO = CTPG.ID_PHIEUGIAO 
                             AND CTPG.ID_SANPHAM = SP.ID_SANPHAM AND NV.ID_NHANVIEN = PG.IDNV_KIEMTRA AND CH.ID_CUAHANG = NV.ID_CUAHANG
                             GROUP BY CTPG.ID_PHIEUGIAO,PG.ID_PHIEUGIAO, PG.ID_PHIEUDAT, PG.IDNV_KIEMTRA, CH.ID_CUAHANG, PG.ID_NHACUNG, PD.NGAYDAT, PG.NGAYGIAO""";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    PhieuGiaoHang_DTO pgh = new PhieuGiaoHang_DTO();
                    pgh.setMaPG(rs.getString(1));
                    pgh.setMaPD(rs.getString(2));
                    pgh.setMaNV(rs.getString(3));
                    pgh.setMaCH(rs.getString (4));
                    pgh.setMaNC(rs.getString(5));
                    pgh.setNgaydat(rs.getString(6));
                    pgh.setNgaygiao(rs.getString(7));
                    pgh.setTongtien(rs.getDouble(8));
                    arr.add(pgh);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
}

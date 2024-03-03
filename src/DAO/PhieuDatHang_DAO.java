/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.LichSuPhieuDat_DTO;
import DTO.ChiTietPhieuDat_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuDatHang_DAO {
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
    
    public ArrayList<LichSuPhieuDat_DTO> getAllLichSuDatHang(){
        ArrayList<LichSuPhieuDat_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = """
                             SELECT PD.ID_PHIEUDAT , SUM(CTPD.SOLUONG), SUM(SP.GIA*CTPD.SOLUONG), PD.ID_NHACUNG, PD.NGAYDAT
                             FROM PHIEU_DAT_HANG PD, CHI_TIET_PHIEU_DAT CTPD, SAN_PHAM SP
                             WHERE PD.ID_PHIEUDAT = CTPD.ID_PHIEUDAT AND SP.ID_SANPHAM = CTPD.ID_SANPHAM
                             GROUP BY CTPD.ID_PHIEUDAT, PD.ID_PHIEUDAT, PD.ID_NHACUNG, PD.NGAYDAT""";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    LichSuPhieuDat_DTO lspd = new LichSuPhieuDat_DTO();
                    lspd.setMaPD(rs.getString(1));
                    lspd.setTongsoluong(rs.getString(2));
                    lspd.setTongtien(rs.getDouble(3));
                    lspd.setMaNC(rs.getString(4));
                    lspd.setNgayDat(rs.getString(5));
                    arr.add(lspd);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public ArrayList<ChiTietPhieuDat_DTO> getAllChiTietPhieuDat(){
        ArrayList<ChiTietPhieuDat_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = """
                             SELECT CTPD.ID_PHIEUDAT, CTPD.ID_SANPHAM, SP.TENSP, SP.GIA , CTPD.SOLUONG, SP.GIA*CTPD.SOLUONG
                             FROM PHIEU_DAT_HANG PD, CHI_TIET_PHIEU_DAT CTPD, SAN_PHAM SP
                             WHERE PD.ID_PHIEUDAT = CTPD.ID_PHIEUDAT AND SP.ID_SANPHAM = CTPD.ID_SANPHAM""";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    ChiTietPhieuDat_DTO ctpd = new ChiTietPhieuDat_DTO();
                    ctpd.setMaPD(rs.getString(1));
                    ctpd.setMaSP(rs.getString(2));
                    ctpd.setTenSP(rs.getString(3));
                    ctpd.setGia(rs.getDouble(4));
                    ctpd.setSl(rs.getInt(5));
                    ctpd.setThanhTien(rs.getDouble(6));
                    arr.add(ctpd);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.BangLuong_DTO;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author trita
 */
public class BangLuong_DAO {
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
    
    public ArrayList<BangLuong_DTO> getAllBangLuong(){
        ArrayList<BangLuong_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM BANG_LUONG";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    BangLuong_DTO bl = new BangLuong_DTO();
                    bl.setMaNV(rs.getString(2));
                    bl.setThang(rs.getInt(3));
                    bl.setNam(rs.getInt(4));
                    bl.setSoNgayCong(rs.getInt(5));
                    bl.setPhuCapAnUong(rs.getDouble(6));
                    bl.setPhuCapXang(rs.getDouble(7));
                    bl.setTienThuong(rs.getDouble(8));
                    bl.setMoTaTienThuong(rs.getString(9));
                    bl.setBaoHiem(rs.getDouble(10));
                    bl.setThue(rs.getDouble(11));
                    bl.setKhauTruKhac(rs.getDouble(12));
                    bl.setMoTaKhauTru(rs.getString(13));
                    bl.setLuongDuocLanh(rs.getDouble(14));
                    bl.setTamUng(rs.getDouble(15));
                    bl.setThoiGianTamUng(rs.getString(16));
                    bl.setLuongThucNhan(rs.getDouble(17));
                    bl.setThoiGianNhan(rs.getString(18));
                    arr.add(bl);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public boolean addBangLuong(BangLuong_DTO bl){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = """
                             INSERT INTO BANG_LUONG(ID_NHANVIEN,THANG,NAM,SONGAYCONG,PHUCAPANUONG,PHUCAPXANG,
                             TIENTHUONG,MOTATIENTHUONG,BAOHIEM,THUE,KHAUTRUKHAC,MOTAKHAUTRU,LUONGDUOCLANH,TAMUNG,THOIGIANTAMUNG,LUONGTHUCNHAN,THOIGIANNHAN)
                             VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)""";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, bl.getMaNV());
                stmt.setInt(2, bl.getThang());
                stmt.setInt(3, bl.getNam());
                stmt.setInt(4, bl.getSoNgayCong());
                stmt.setDouble(5, bl.getPhuCapAnUong());
                stmt.setDouble(6, bl.getPhuCapXang());
                stmt.setDouble(7, bl.getTienThuong());
                stmt.setString(8, bl.getMoTaTienThuong());
                stmt.setDouble(9, bl.getBaoHiem());
                stmt.setDouble(10, bl.getThue());
                stmt.setDouble(11, bl.getKhauTruKhac());
                stmt.setString(12, bl.getMoTaKhauTru());
                stmt.setDouble(13, bl.getLuongDuocLanh());
                stmt.setDouble(14, bl.getTamUng());
                stmt.setString(15, bl.getThoiGianTamUng());
                stmt.setDouble(16, bl.getLuongThucNhan());
                stmt.setString(17, bl.getThoiGianNhan());
                if(stmt.executeUpdate()==1)
                    result=true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean delBangLuong(BangLuong_DTO bl){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM BANG_LUONG WHERE ID_NHANVIEN=? AND THANG = ? AND NAM = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,bl.getMaNV());
                stmt.setInt(2,bl.getThang());
                stmt.setInt(3,bl.getNam());
                if(stmt.executeUpdate()==1)
                    result = true;
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}

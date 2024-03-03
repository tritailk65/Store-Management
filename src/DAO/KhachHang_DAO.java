/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHang_DTO;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author trita
 */
public class KhachHang_DAO {
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
    
    public ArrayList<KhachHang_DTO> getAllKhachHangThanThiet(){
        ArrayList<KhachHang_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = """
                             SELECT HD.ID_KHACHHANG, KH.HOTEN, KH.DIACHI, KH.SDT, KH.LOAIKHACHHANG, KH.GIOITINH, KH.CMND_CCCD, SUM(CTHD.SOLUONG*SP.GIA) AS 'TIENHANGTICHLUY'
                             FROM  CHI_TIET_HOA_DON CTHD, HOA_DON HD, SAN_PHAM SP, KHACH_HANG KH
                             WHERE CTHD.ID_HOADON = HD.ID_HOADON AND CTHD.ID_SANPHAM = SP.ID_SANPHAM AND HD.ID_KHACHHANG = KH.ID_KHACHHANG
                             GROUP BY HD.ID_KHACHHANG,KH.HOTEN, KH.DIACHI, KH.LOAIKHACHHANG, KH.SDT,KH.GIOITINH, KH.CMND_CCCD""";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    KhachHang_DTO kh = new KhachHang_DTO();
                    kh.setMaKH(rs.getString(1));
                    kh.setTenKH(rs.getString(2));
                    kh.setDiaChi(rs.getString(3));
                    kh.setSdt(rs.getString(4));
                    kh.setXepHang(rs.getString(5));
                    kh.setGioiTinh(rs.getString(6));
                    kh.setCMND_CCCD(rs.getString(7));
                    kh.setTienHangTichLuy(rs.getDouble(8));
                    arr.add(kh);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public boolean addKhachHang(KhachHang_DTO kh){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO KHACH_HANG(ID_KHACHHANG,HOTEN,DIACHI,LOAIKHACHHANG) VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, kh.getMaKH());
                stmt.setString(2, kh.getTenKH());
                stmt.setString(3, kh.getDiaChi());
                stmt.setString(4, kh.getXepHang());
                if(stmt.executeUpdate()>=1)
                    result=true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean hasKhachHangID(String id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM KHACH_HANG WHERE ID_KHACHHANG='"+id+"'";
                Statement stmt =con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result=rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean delKhachHang(KhachHang_DTO kh){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM KHACH_HANG WHERE ID_KHACHHANG = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,kh.getMaKH());
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
    
    public boolean editKhachHang(KhachHang_DTO kh){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "UPDATE KHACH_HANG SET HOTEN = ?, DIACHI = ?, SDT = ?, LOAIKHACHHANG = ?, GIOITINH=?, CMND_CCCD=? WHERE ID_KHACHHANG=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, kh.getTenKH());
                stmt.setString(2, kh.getDiaChi());
                stmt.setString(3, kh.getSdt());
                stmt.setString(4, kh.getXepHang());
                stmt.setString(5, kh.getGioiTinh());
                stmt.setString(6, kh.getCMND_CCCD());
                stmt.setString(7, kh.getMaKH());
                if(stmt.executeUpdate()==1){
                    result=true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHoaDon_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDon_DAO {
    private Connection con;
    public boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://TRI-TAI\\SQLEXPRESS:1433;DatabaseName=QUAN_LY_CUA_HANG_BAN_QUAN_AO;encrypt=true;trustServerCertificate=true;";
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
    
    public ArrayList<ChiTietHoaDon_DTO> getAllchiTietHD(){
        ArrayList<ChiTietHoaDon_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try {
                String query = "SELECT CT.ID_HOADON, SP.ID_SANPHAM, SP.TENSP, CT.SOLUONG, SP.GIA, (CT.SOLUONG*SP.GIA) AS 'Thanh Tien' "
                                + "FROM CHI_TIET_HOA_DON AS CT, SAN_PHAM AS SP "
                                + "WHERE CT.ID_SANPHAM = SP.ID_SANPHAM ";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                    cthd.setId_hoaDon(rs.getString(1));
                    cthd.setId_SP(rs.getString(2));
                    cthd.setTenSP(rs.getString(3));
                    cthd.setSL(rs.getInt(4));
                    cthd.setGia(rs.getInt(5));
                    cthd.setThanhTien(rs.getInt(6));
                    arr.add(cthd);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public ArrayList<ChiTietHoaDon_DTO> getAll_ChiTietHoaDon_By_idHoaDon(String id_HoaDon){
        ArrayList<ChiTietHoaDon_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try {
                String query = "SELECT CT.ID_HOADON, SP.ID_SANPHAM, SP.TENSP, CT.SOLUONG, SP.GIA, (CT.SOLUONG*SP.GIA) AS 'Thanh Tien' "
                                + "FROM CHI_TIET_HOA_DON AS CT, SAN_PHAM AS SP "
                                + "WHERE CT.ID_SANPHAM = SP.ID_SANPHAM AND CT.ID_HOADON = '"+id_HoaDon+"'";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                    cthd.setId_hoaDon(rs.getString(1));
                    cthd.setId_SP(rs.getString(2));
                    cthd.setTenSP(rs.getString(3));
                    cthd.setSL(rs.getInt(4));
                    cthd.setGia(rs.getInt(5));
                    cthd.setThanhTien(rs.getInt(6));
                    arr.add(cthd);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public ArrayList getAll_TenCuaHang(){
        ArrayList arr = new ArrayList();
        if(openConnection()){
            try {
                String query = "SELECT CH.TENCUAHANG FROM CUA_HANG AS CH";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String name = rs.getString(1);
                    arr.add(name);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public ArrayList getAll_TenSanPham(){
        ArrayList arr = new ArrayList();
        if(openConnection()){
            try {
                String query = "SELECT SP.TENSP FROM SAN_PHAM AS SP";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String name = rs.getString(1);
                    arr.add(name);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public int find_DonGia_By_TenSP(String tenSP){
        int gia = 0;
        if(openConnection()){
            try {
                String query = "SELECT SP.GIA FROM SAN_PHAM AS SP WHERE TENSP = N'"+tenSP+"'";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    gia =rs.getInt(1);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return gia;
    }
    
    public String find_idSP_By_TenSP(String tenSP){
        String id = "";
        if(openConnection()){
            try {
                String query = "SELECT SP.ID_SANPHAM FROM SAN_PHAM AS SP WHERE SP.TENSP = N'"+tenSP+"'";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    id =rs.getString(1);
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return id;
    }
    
    public boolean is_ChiTietHoaDon_Exist(ChiTietHoaDon_DTO ct){
        boolean result = false;
        if(openConnection()){
            try {
                String query = "SELECT * FROM CHI_TIET_HOA_DON AS CT "
                                + "WHERE CT.ID_HOADON = N'"+ct.getId_hoaDon()+"' AND CT.ID_SANPHAM = N'"+find_idSP_By_TenSP(ct.getTenSP())+"' ";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                result = rs.next();
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean add_ChiTietHoaDon(ChiTietHoaDon_DTO ct){
        boolean result = false;
        if(openConnection()){
            try {
                String query = "INSERT INTO CHI_TIET_HOA_DON VALUES (?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ct.getId_hoaDon());
                stmt.setString(2, ct.getId_SP());
                stmt.setString(3, ""+ct.getSL());
                if(stmt.executeUpdate()>=1)
                    result=true;
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean del_ChiTietHoaDon(ChiTietHoaDon_DTO ct){
        boolean result = false;
        if(openConnection()){
            try {
                String query = "DELETE FROM CHI_TIET_HOA_DON WHERE ID_HOADON = ? AND ID_SANPHAM = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ct.getId_hoaDon());
                stmt.setString(2, ct.getId_SP());
                if(stmt.executeUpdate()==1)
                    result=true;
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean update_ChiTietHoaDon(ChiTietHoaDon_DTO ct){
        boolean result = false;
        if(openConnection()){
            try {
                String query = "UPDATE CHI_TIET_HOA_DON SET SOLUONG = ? WHERE ID_HOADON = ? AND ID_SANPHAM = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1, ct.getSL());
                stmt.setString(2, ct.getId_hoaDon());
                stmt.setString(3, ct.getId_SP());
                if(stmt.executeUpdate()==1){
                    result=true;
                }
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean del_ChiTietHoaDon_By_idCTHD(ChiTietHoaDon_DTO ct){
        boolean result = false;
        if(openConnection()){
            try {
                String query = "DELETE FROM CHI_TIET_HOA_DON WHERE ID_HOADON = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ct.getId_hoaDon());
                if(stmt.executeUpdate()==1)
                    result=true;
            }catch (SQLException e){
                System.out.println(e);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}

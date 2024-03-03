/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.KhoHang_DTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author haile
 */

public class KhoHang_DAO {
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
    
    public ArrayList<KhoHang_DTO> getAllKhoHang(){
        ArrayList<KhoHang_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = """
                             SELECT SP.ID_SANPHAM, SP.TENSP, K.SIZE, K.SOLUONG, SP.GIA, K.THOIGIANCAPNHAT
                             FROM KHO K, SAN_PHAM SP
                             WHERE K.ID_SANPHAM = SP.ID_SANPHAM
                             GROUP BY SP.ID_SANPHAM, SP.TENSP, K.SIZE, K.SOLUONG, SP.GIA, K.THOIGIANCAPNHAT""";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    KhoHang_DTO kh = new KhoHang_DTO();
                    kh.setMaSP(rs.getString(1));
                    kh.setTenSP(rs.getString(2));
                    kh.setSize(rs.getString(3));
                    kh.setSL(rs.getInt(4));
                    kh.setGia(rs.getDouble(5));
                    kh.setTGCapNhat(rs.getString(6));
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
    
    public boolean hasSizeSanPham(String size, String id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM KHO WHERE ID_SANPHAM='"+id+"'  AND SIZE = '"+size+"' ";
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
    
    public boolean addKhoHang(KhoHang_DTO kho){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO KHO VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);               
                stmt.setString(1, kho.getMaSP());
                stmt.setString(2, kho.getSize());
                stmt.setInt(3, kho.getSL());
                stmt.setString(4, kho.getTGCapNhat());
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
    
    public boolean delKhoHang(KhoHang_DTO kh){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM KHO WHERE ID_SANPHAM =? AND SIZE = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, kh.getMaSP());
                stmt.setString(2, kh.getSize());
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
    
    public boolean editKhoHang(KhoHang_DTO kho){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "UPDATE KHO SET SIZE = ?, SOLUONG = ?, THOIGIANCAPNHAT = ?  WHERE ID_SANPHAM = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, kho.getSize());
                stmt.setInt(2, kho.getSL());
                stmt.setString(3, kho.getTGCapNhat());
                stmt.setString(4, kho.getMaSP());
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

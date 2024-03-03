/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.SanPham_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class SanPham_DAO {
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
    
    public ArrayList<SanPham_DTO> getAllSanPham(){
        ArrayList<SanPham_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM SAN_PHAM";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanPham_DTO sp = new SanPham_DTO();
                    sp.setMaSP(rs.getString(1));
                    sp.setTenSP(rs.getString(2));
                    sp.setMoTa(rs.getString(3));
                    sp.setThuocTinh(rs.getString(4));
                    sp.setGia(rs.getDouble(5));
                    sp.setMaNC(rs.getString(6));
                    arr.add(sp);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public ArrayList<SanPham_DTO> findSanPham(String ten){
        ArrayList<SanPham_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM SAN_PHAM WHERE TENSP LIKE N'%"+ten+"%'";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SanPham_DTO sp = new SanPham_DTO();
                    sp.setMaSP(rs.getString(1));
                    sp.setTenSP(rs.getString(2));
                    arr.add(sp);
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

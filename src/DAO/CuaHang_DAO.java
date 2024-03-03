/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.CuaHang_DTO;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author trita
 */
public class CuaHang_DAO {
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
       
    public ArrayList<CuaHang_DTO> getAllCuaHang(){
        ArrayList<CuaHang_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM CUA_HANG";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    CuaHang_DTO ch = new CuaHang_DTO();
                    ch.setMaCH(rs.getString(1));
                    ch.setTenCuaHang(rs.getString(2));
                    ch.setDiaChi(rs.getString(3));
                    ch.setTinhTrang(rs.getString(4));
                    ch.setSdt(rs.getString(5));
                    arr.add(ch);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public boolean addCuaHang(CuaHang_DTO ch){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO CUA_HANG VALUES(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, ch.getMaCH());
                stmt.setString(2, ch.getTenCuaHang());
                stmt.setString(3, ch.getDiaChi());
                stmt.setString(4, ch.getTinhTrang());
                stmt.setString(5, ch.getSdt());
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
    
    public boolean hasCuaHangID(String id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM CUA_HANG WHERE ID_CUAHANG='"+id+"'";
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
    
    public boolean delCuaHang(CuaHang_DTO ch){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM CUA_HANG WHERE ID_CUAHANG =?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, ch.getMaCH());
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
    
    public boolean editCuaHang(CuaHang_DTO ch){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "UPDATE CUA_HANG SET TENCUAHANG = ?, DIACHI = ?, TINHTRANG = ?, SDT = ? WHERE ID_CUAHANG=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, ch.getTenCuaHang());
                stmt.setString(2, ch.getDiaChi());
                stmt.setString(3, ch.getTinhTrang());
                stmt.setString(4, ch.getSdt());
                stmt.setString(5, ch.getMaCH());
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

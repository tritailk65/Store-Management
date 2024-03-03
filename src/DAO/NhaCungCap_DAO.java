/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhaCungCap_DTO;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author trita
 */
public class NhaCungCap_DAO {
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
       
    public ArrayList<NhaCungCap_DTO> getAllNhaCung(){
        ArrayList<NhaCungCap_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM NHA_CUNG_CAP";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    NhaCungCap_DTO nc = new NhaCungCap_DTO();
                    nc.setMaNC(rs.getString(1));
                    nc.setTenNC(rs.getString(2));
                    nc.setSdt(rs.getString(3));
                    nc.setDiachi(rs.getString(4));
                    arr.add(nc);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }    
        return arr;
    }
    
    public boolean addNhaCungCap(NhaCungCap_DTO nc){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO NHA_CUNG_CAP VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nc.getMaNC());
                stmt.setString(2, nc.getTenNC());
                stmt.setString(3, nc.getSdt());
                stmt.setString(4, nc.getDiachi());
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
    
    public boolean hasNhaCungCapID(String id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM NHA_CUNG_CAP WHERE ID_NHACUNG='"+id+"'";
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
    
    public boolean delNhaCungCap(NhaCungCap_DTO nc){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM NHA_CUNG_CAP WHERE ID_NHACUNG=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nc.getMaNC());
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
    
    public boolean editNhaCungCap(NhaCungCap_DTO  nc){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "UPDATE NHA_CUNG_CAP SET TENNHACUNG = ?, SDT = ?, DIACHI = ? WHERE ID_NHACUNG=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nc.getTenNC());
                stmt.setString(2, nc.getSdt());
                stmt.setString(3, nc.getDiachi());
                stmt.setString(4, nc.getMaNC());
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

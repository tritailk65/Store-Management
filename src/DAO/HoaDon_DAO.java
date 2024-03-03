/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import BUS.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class HoaDon_DAO {
    private Connection con;
    private String[] idhd;
    private ArrayList<HoaDon_DTO> idhdList = new ArrayList<>();
    
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
    
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        ArrayList<HoaDon_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM HOA_DON";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    HoaDon_DTO hd = new HoaDon_DTO();
                    hd.setId_hoadon(rs.getString(1));
                    hd.setId_cuahang(rs.getString(2));
                    hd.setNgaylap(rs.getString(3));
                    hd.setId_nhanvien(rs.getString(4));
                    hd.setId_khachhang(rs.getString(5));
                    arr.add(hd);
                    idhdList.add(hd);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public boolean addHoaDon(HoaDon_DTO hd){
        boolean result =false;
        if(openConnection()){
            for(int i =0;i<=idhdList.size();i++){
                HoaDon_DTO newHD  = idhdList.get(i);
                
                
            }
            
            try{
                String sql = "INSERT INTO KHACH_HANG(ID_CUAHANG,NGAYLAP,ID_NHANVIEN,iD_KHACHHANG,MOTA) VALUES(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, hd.getId_hoadon());
                stmt.setString(2, hd.getId_cuahang());
                stmt.setString(3, hd.getNgaylap());
                stmt.setString(4, hd.getId_nhanvien());
                stmt.setString(5, hd.getId_khachhang());
                stmt.setString(6, hd.getMota());
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
    
    
}

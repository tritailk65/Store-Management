/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.HoaDonChiTra_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class HoaDonChiTra_DAO {
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
       
    public ArrayList<HoaDonChiTra_DTO> getAllHoaDonChiTra(){
        ArrayList<HoaDonChiTra_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM HOA_DON_CHI_TRA";
                Statement stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    HoaDonChiTra_DTO hdct = new HoaDonChiTra_DTO();
                    hdct.setMaHDCT(rs.getString(1));
                    hdct.setMaNV(rs.getString(2));
                    hdct.setMaCH(rs.getString(3));
                    hdct.setNgayLap(rs.getString(4));
                    hdct.setMoTa(rs.getString(5));
                    hdct.setTongTien(rs.getDouble(6));
                    arr.add(hdct);
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

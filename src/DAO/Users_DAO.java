/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.Users_DTO;
import java.sql.*;

/**
 *
 * @author trita
 */
public class Users_DAO {
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
    
    public boolean checkPasswordUsers(String user,String pwd){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM USERS WHERE USERNAME='"+user+"' AND PASSWORD='"+pwd+"'";
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
    
    public boolean addUser(Users_DTO us){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO USERS(USERNAME,PASSWORD) VALUES(?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, us.getUsername());
                stmt.setString(2, us.getPassword());
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
    
    public boolean hasUser(String username){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM USERS WHERE USERNAME='"+username+"'";
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
}

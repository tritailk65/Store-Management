/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.Users_DAO;
import DTO.Users_DTO;

/**
 *
 * @author trita
 */
public class Users_BUS {
    Users_DAO userDAO = new Users_DAO();
   
    public boolean checkPasswordUsers(Users_DTO us){
        return userDAO.checkPasswordUsers(us.getUsername(),us.getPassword());
    }
    
    public String addUser(Users_DTO us){

        if(userDAO.addUser(us))
            return "Thêm tài khoản thành công";
        return "Thêm tai khoản thất bại";
    }
    
    public boolean hasUser(Users_DTO us){
        return userDAO.hasUser(us.getUsername());
    }
}

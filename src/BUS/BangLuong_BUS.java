/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.BangLuong_DAO;
import DTO.BangLuong_DTO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class BangLuong_BUS {
    BangLuong_DAO blDAO = new BangLuong_DAO();
    public ArrayList<BangLuong_DTO> getAllBangLuong(){
        return blDAO.getAllBangLuong();
    }
    
    public String addBangLuong(BangLuong_DTO bl){
        if(blDAO.addBangLuong(bl))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delBangLuong(BangLuong_DTO nv){
        if(blDAO.delBangLuong(nv)==true)
            return "Xóa thành công";
        return "Xóa thất bại";
    }
}

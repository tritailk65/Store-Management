/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.CuaHang_DAO;
import DTO.CuaHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class CuaHang_BUS {
    CuaHang_DAO chDAO = new CuaHang_DAO();
    public ArrayList<CuaHang_DTO> getAllCuaHang(){
        return chDAO.getAllCuaHang();
    }
    
    public String addCuaHang(CuaHang_DTO ch){
        if(chDAO.hasCuaHangID(ch.getMaCH())){
            return "Mã cửa hàng đã tồn tại";
        }
        if(chDAO.addCuaHang(ch))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delCuaHang(CuaHang_DTO ch){
        if(chDAO.delCuaHang(ch))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    
    public String editCuaHang(CuaHang_DTO ch){
        if(chDAO.editCuaHang(ch))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
}

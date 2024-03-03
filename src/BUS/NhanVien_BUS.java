/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.NhanVien_DTO;
import DAO.NhanVien_DAO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class NhanVien_BUS {
    NhanVien_DAO nvDAO = new NhanVien_DAO();
    
    public ArrayList<NhanVien_DTO> getAllNhanVien(){
        return nvDAO.getAllNhanVien();
    }
    
    public String delNhanVIen(NhanVien_DTO nv){
        if(nvDAO.delNhanVien(nv)==true)
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    
    public String editNhanVien(NhanVien_DTO nv){
        if(nvDAO.editNhanVien(nv)==true){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }
    
    public String addCuaHang(NhanVien_DTO ch){
        if(nvDAO.hasNhanVienID(ch.getMaCH())){
            return "Mã cửa hàng đã tồn tại";
        }
        if(nvDAO.addNhanVien(ch))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
}

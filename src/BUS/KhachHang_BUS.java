/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.KhachHang_DAO;
import DTO.KhachHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class KhachHang_BUS {
    KhachHang_DAO khDAO = new KhachHang_DAO();
    public ArrayList<KhachHang_DTO> getAllKhachHangThanThiet(){
        return khDAO.getAllKhachHangThanThiet();
    }
    
    public String addkKhachHang(KhachHang_DTO kh){
        if(khDAO.hasKhachHangID(kh.getMaKH())){
            return "Mã khách hàng đã tồn tại";
        }
        if(khDAO.addKhachHang(kh))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delKhachHang(KhachHang_DTO kh){
        if(khDAO.delKhachHang(kh))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    
    public String editKhachHang(KhachHang_DTO kh){
        if(khDAO.editKhachHang(kh))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
}

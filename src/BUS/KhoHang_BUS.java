/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.KhoHang_DTO;
import DAO.KhoHang_DAO;
import java.util.ArrayList;
/**
 *
 * @author haile
 */
public class KhoHang_BUS {
    KhoHang_DAO khDAO = new KhoHang_DAO();
    public ArrayList<KhoHang_DTO> getAllKhoHang() {
        return khDAO.getAllKhoHang();
    }
   
    public String addKhoHang(KhoHang_DTO kh){           
        if(khDAO.hasSizeSanPham(kh.getSize(),kh.getMaSP())) {
            return "Sản phẩm đã có dữ liệu tồn kho, vui lòng thử lại";
        } else {
        }
        if(khDAO.addKhoHang(kh)){
            return "Thêm dữ liệu tồn kho thành công";
        }
        else {
            return "Thêm dữ liệu tồn kho thất bại";
        }
    }
    
    public String delKhoHang(KhoHang_DTO kh){
        if(khDAO.delKhoHang(kh))
            return "Xoá tồn kho sản phẩm " +kh.getMaSP()+ " size " + kh.getSize()+ " thành công";
        return "Xoá tồn kho sản phẩm " +kh.getMaSP()+ " size " + kh.getSize()+ " thất bại";
    }
    
    public String editKhoHang(KhoHang_DTO kh){
        if(khDAO.editKhoHang(kh))
            return " Chỉnh sửa tồn kho sản phẩm " +kh.getMaSP()+ " size " + kh.getSize()+ " thành công";
        return "chỉnh tồn kho sản phẩm " +kh.getMaSP()+ " size " + kh.getSize()+ " thất bại";
    }
}

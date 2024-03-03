/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap_DTO;
import java.util.ArrayList;


/**
 *
 * @author trita
 */
public class NhaCungCap_BUS {
    NhaCungCap_DAO ncDAO = new NhaCungCap_DAO();
    public ArrayList<NhaCungCap_DTO> getAllNhaCung(){
        return ncDAO.getAllNhaCung();
    }
    
    public String addNhaCungCap(NhaCungCap_DTO nc){
        if(ncDAO.hasNhaCungCapID(nc.getMaNC())){
            return "Mã cửa hàng đã tồn tại";
        }
        if(ncDAO.addNhaCungCap(nc))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delNhaCungCap(NhaCungCap_DTO nc){
        if(ncDAO.delNhaCungCap(nc))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
    
        public String editNhaCungCap(NhaCungCap_DTO nc){
        if(ncDAO.editNhaCungCap(nc))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
}

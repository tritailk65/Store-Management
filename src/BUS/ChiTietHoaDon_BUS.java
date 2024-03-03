/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDon_DAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDon_BUS {
    ChiTietHoaDon_DAO cthd = new ChiTietHoaDon_DAO();
    public ArrayList<ChiTietHoaDon_DTO> getAllchiTietHD(){
        return cthd.getAllchiTietHD();
    }
    
    public ArrayList<ChiTietHoaDon_DTO> getAll_ChiTietHoaDon_By_idHoaDon(String id_HoaDon){
        return cthd.getAll_ChiTietHoaDon_By_idHoaDon(id_HoaDon);
    }
    
    public ArrayList getAll_TenCuaHang(){
        return cthd.getAll_TenCuaHang();
    }
    
    public ArrayList getAll_TenSanPham(){
        return cthd.getAll_TenSanPham();
    }
    
    public int find_DonGia_By_TenSP(String tenSP){
        return cthd.find_DonGia_By_TenSP(tenSP);
    }
    
    public String find_idSP_By_TenSP(String tenSP){
        return cthd.find_idSP_By_TenSP(tenSP);
    }
    
    public int add_CTHD(ChiTietHoaDon_DTO cthd_them_vao){
        if(cthd.is_ChiTietHoaDon_Exist(cthd_them_vao)){
            return 2;
        } else {
            if(cthd.add_ChiTietHoaDon(cthd_them_vao)){
                return 0; // them thanh cong
            }
            return 1; // them that bai
        }
    }
    
    public boolean del_ChiTietHoaDon(ChiTietHoaDon_DTO ct){
        return cthd.del_ChiTietHoaDon(ct);
    }
    
    public boolean update_CTHD(ChiTietHoaDon_DTO cthd_them_vao){
        return cthd.update_ChiTietHoaDon(cthd_them_vao);
    }
    
    public boolean del_ChiTietHoaDon_By_idCTHD(ChiTietHoaDon_DTO ct){
        return cthd.del_ChiTietHoaDon_By_idCTHD(ct);
    }
}

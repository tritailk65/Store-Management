/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DoanhThu_DAO;
import DTO.DoanhThu_DTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DoanhThu_BUS {
    DoanhThu_DAO dt_DAO = new DoanhThu_DAO();
    public ArrayList<DoanhThu_DTO> getAllDoanhThu(){
        return dt_DAO.getAllDoanhThu();
    }
    
    public DoanhThu_DTO get_DoanhThu_by_month_year_idCH(int month, int year, String id_CuaHang){
        return dt_DAO.get_DoanhThu_by_month_year_idCH(month, year, id_CuaHang);
    }
    
    public boolean add_DoanhThu(DoanhThu_DTO dt){
        return dt_DAO.add_DoanhThu(dt);
    }
    
    public ArrayList get_cacNamKeTuNamThanhLap_by_tenCH(String tenCH){
        return dt_DAO.get_cacNamKeTuNamThanhLap_by_tenCH(tenCH);
    }
    
    public ArrayList get_cacIDnhanVien_by_tenCH(String tenCH){
        return dt_DAO.get_cacIDnhanVien_by_tenCH(tenCH);
    }
    
    public boolean is_any_HoaDon_at_this_time(int month, int year, String id_CuaHang){
        return dt_DAO.is_any_HoaDon_at_this_time(month, year, id_CuaHang);
    }
    
    public boolean is_any_DoanhThu_at_this_time(int month, int year, String id_CuaHang){
        return dt_DAO.is_any_DoanhThu_at_this_time(month, year, id_CuaHang);
    }
    
    public boolean is_any_DoanhThu_has_changed_at_this_time(int month, int year, String id_CuaHang){
        return dt_DAO.is_any_DoanhThu_has_changed_at_this_time(month, year, id_CuaHang);
    }
    
    public boolean doanhThu_need_update(int month, int year, String id_CuaHang){
        return dt_DAO.doanhThu_need_update(month, year, id_CuaHang);
    }
    
    public boolean update_DoanhThu(DoanhThu_DTO dt){
        return dt_DAO.update_DoanhThu(dt);
    }
    
    public int tinh_soLuong_by_month_year_tenSP_idCH_moTa(int month, int year, String tenSP, String id_CuaHang, String moTa){
        return dt_DAO.tinh_soLuong_by_month_year_tenSP_idCH_moTa(month, year, tenSP, id_CuaHang, moTa);
    }
    
    public int tinh_doanhThu_by_month_year_tenSP_idCH_moTa(int month, int year, String tenSP, String id_CuaHang, String moTa){
        return dt_DAO.tinh_doanhThu_by_month_year_tenSP_idCH_moTa(month, year, tenSP, id_CuaHang, moTa);
    }
    
    public ArrayList getAll_tenSP(){
        return dt_DAO.getAll_tenSP();
    }
    
    public int tinh_SoLuongHD_by_month_year_idNV(int month, int year, String id_nv, String id_ch){
        return dt_DAO.tinh_SoLuongHD_by_month_year_idNV(month, year, id_nv, id_ch);
    }
    
    public int tinh_doanhSo_by_month_year_idNV(int month, int year, String id_nv, String id_ch){
        return dt_DAO.tinh_doanhSo_by_month_year_idNV(month, year, id_nv, id_ch);
    }
}

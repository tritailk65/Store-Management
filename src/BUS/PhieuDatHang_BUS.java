/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.PhieuDatHang_DAO;
import DTO.ChiTietPhieuDat_DTO;
import DTO.LichSuPhieuDat_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuDatHang_BUS {
    PhieuDatHang_DAO pdhDAO = new PhieuDatHang_DAO();
    public ArrayList<LichSuPhieuDat_DTO> getAllLichSuPhieuDat(){
        return pdhDAO.getAllLichSuDatHang();
    }
    
    public ArrayList<ChiTietPhieuDat_DTO> getAllChiTietPhieuDat(){
        return pdhDAO.getAllChiTietPhieuDat();
    }
    
    
}

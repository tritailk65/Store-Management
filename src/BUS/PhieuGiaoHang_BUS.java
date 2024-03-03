/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.PhieuGiaoHang_DAO;
import DTO.PhieuGiaoHang_DTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuGiaoHang_BUS {
    PhieuGiaoHang_DAO pghDAO = new PhieuGiaoHang_DAO();
    public ArrayList<PhieuGiaoHang_DTO> getAllPhieuGiaoHang(){
        return pghDAO.getAllPhieuGiaoHang();
    }
}

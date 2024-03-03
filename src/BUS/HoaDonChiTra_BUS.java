/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.HoaDonChiTra_DAO;
import DTO.HoaDonChiTra_DTO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class HoaDonChiTra_BUS {
    HoaDonChiTra_DAO hdctDAO = new HoaDonChiTra_DAO();
    public ArrayList<HoaDonChiTra_DTO> getAllHoaDonChiTra(){
        return hdctDAO.getAllHoaDonChiTra();
    }
}

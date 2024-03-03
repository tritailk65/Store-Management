/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.SanPham_DAO;
import DTO.SanPham_DTO;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class SanPham_BUS {
    SanPham_DAO spDAO = new SanPham_DAO();
    public ArrayList<SanPham_DTO> getAllSanPham(){
        return spDAO.getAllSanPham();
    }
    
    public ArrayList<SanPham_DTO> findSanPham(String ten){
        return spDAO.findSanPham(ten);
    }
}

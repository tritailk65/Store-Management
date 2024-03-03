/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.*;
import DTO.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class HoaDon_BUS {
     HoaDon_DAO khDAO = new HoaDon_DAO();
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        return khDAO.getAllHoaDon();
    }
    
    
}

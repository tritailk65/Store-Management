/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDon_DTO {
    private String id_hoaDon;
    private String id_SP;
    private String tenSP;
    private int SL;
    private int gia;
    private int thanhTien;

    public ChiTietHoaDon_DTO() {
        this.id_hoaDon = "";
        this.id_SP = "";
        this.tenSP = "";
        this.SL = 0;
        this.gia = 0;
        this.thanhTien = 0;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }
    
    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(String id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}

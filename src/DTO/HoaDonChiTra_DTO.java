/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class HoaDonChiTra_DTO {
    private String maHDCT;
    private String maNV;
    private String maCH;
    private String ngayLap;
    private String moTa;
    private double tongTien;

    public HoaDonChiTra_DTO() {
    }

    public HoaDonChiTra_DTO(String maHDCT, String maNV, String maCH, String ngayLap, String moTa, double tongTien) {
        this.maHDCT = maHDCT;
        this.maNV = maNV;
        this.maCH = maCH;
        this.ngayLap = ngayLap;
        this.moTa = moTa;
        this.tongTien = tongTien;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
}

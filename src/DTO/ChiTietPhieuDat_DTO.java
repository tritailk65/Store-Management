/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuDat_DTO {
    private String maPD;
    private String maSP;
    private String tenSP;
    private int sl;
    private Double gia;
    private Double thanhTien;

    public ChiTietPhieuDat_DTO() {
    }

    public ChiTietPhieuDat_DTO(String maPD, String maSP, String tenSP, int sl, Double gia, Double thanhTien) {
        this.maPD = maPD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.sl = sl;
        this.gia = gia;
        this.thanhTien = thanhTien;
    }

    public String getMaPD() {
        return maPD;
    }

    public void setMaPD(String maPD) {
        this.maPD = maPD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}

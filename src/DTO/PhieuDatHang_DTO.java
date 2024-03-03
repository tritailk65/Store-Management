/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class PhieuDatHang_DTO {
    private String maPD;
    private String maNV;
    private String maNC;
    private String ngayLap;
    private String maSP;
    private int SL;

    public PhieuDatHang_DTO() {
    }

    public PhieuDatHang_DTO(String maPD, String maNV, String maNC, String ngayLap, String maSP, int SL) {
        this.maPD = maPD;
        this.maNV = maNV;
        this.maNC = maNC;
        this.ngayLap = ngayLap;
        this.maSP = maSP;
        this.SL = SL;
    }

    public String getMaPD() {
        return maPD;
    }

    public void setMaPD(String maPD) {
        this.maPD = maPD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class PhieuGiaoHang_DTO {
    private String maPG;
    private String maPD;
    private String maNV;
    private String maCH;
    private String maNC;
    private String ngaydat;
    private String ngaygiao;
    private String maSP;
    private int SL;
    private double tongtien;

    public PhieuGiaoHang_DTO() {
    }

    public PhieuGiaoHang_DTO(String maPG, String maPD, String maNV, String maCH, String maNC, String ngaydat, String ngaygiao, String maSP, int SL, double tongtien) {
        this.maPG = maPG;
        this.maPD = maPD;
        this.maNV = maNV;
        this.maCH = maCH;
        this.maNC = maNC;
        this.ngaydat = ngaydat;
        this.ngaygiao = ngaygiao;
        this.maSP = maSP;
        this.SL = SL;
        this.tongtien = tongtien;
    }

    public String getMaPG() {
        return maPG;
    }

    public void setMaPG(String maPG) {
        this.maPG = maPG;
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

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
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

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
    
}

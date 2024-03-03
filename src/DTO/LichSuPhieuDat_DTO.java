/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class LichSuPhieuDat_DTO {
    private String maPD;
    private String tongsoluong;
    private Double tongtien;
    private String maNC;
    private String ngayDat;

    public LichSuPhieuDat_DTO(String maPD, String tongsoluong, Double tongtien, String maNC, String ngayDat) {
        this.maPD = maPD;
        this.tongsoluong = tongsoluong;
        this.tongtien = tongtien;
        this.maNC = maNC;
        this.ngayDat = ngayDat;
    }

    public LichSuPhieuDat_DTO() {
    }

    public String getMaPD() {
        return maPD;
    }

    public void setMaPD(String maPD) {
        this.maPD = maPD;
    }

    public String getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(String tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }
    
    
}

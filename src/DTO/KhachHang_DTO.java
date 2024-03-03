/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class KhachHang_DTO {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String xepHang;
    private String sdt;
    private String gioiTinh;
    private String CMND_CCCD;
    private double tienHangTichLuy;

    public KhachHang_DTO() {
    }

    public KhachHang_DTO(String maKH, String tenKH, String diaChi, String xepHang, String sdt, String gioiTinh, String CMND_CCCD, double tienHangTichLuy) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.xepHang = xepHang;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.CMND_CCCD = CMND_CCCD;
        this.tienHangTichLuy = tienHangTichLuy;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getXepHang() {
        return xepHang;
    }

    public void setXepHang(String xepHang) {
        this.xepHang = xepHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
    }

    public double getTienHangTichLuy() {
        return tienHangTichLuy;
    }

    public void setTienHangTichLuy(double tienHangTichLuy) {
        this.tienHangTichLuy = tienHangTichLuy;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class CuaHang_DTO {
    private String maCH;
    private String tenCuaHang;
    private String diaChi;
    private String tinhTrang;
    private String sdt;

    public CuaHang_DTO() {
    }

    public CuaHang_DTO(String maCH, String tenCuaHang, String diaChi, String tinhTrang, String sdt) {
        this.maCH = maCH;
        this.tenCuaHang = tenCuaHang;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
        this.sdt = sdt;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}

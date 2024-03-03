/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DoanhThuTheo_NhanVien_DTO {
    private String id_nhanVien;
    private String ten_nhanVien;
    private int sl_donHang;
    private int tienHang;
    private int thue;
    private int doanhSo;

    public DoanhThuTheo_NhanVien_DTO() {
        this.id_nhanVien = "";
        this.ten_nhanVien = "";
        this.sl_donHang = 0;
        this.tienHang = 0;
        this.thue = 0;
        this.doanhSo = 0;
    }

    public String getId_nhanVien() {
        return id_nhanVien;
    }

    public void setId_nhanVien(String id_nhanVien) {
        this.id_nhanVien = id_nhanVien;
    }

    public String getTen_nhanVien() {
        return ten_nhanVien;
    }

    public void setTen_nhanVien(String ten_nhanVien) {
        this.ten_nhanVien = ten_nhanVien;
    }

    public int getSl_donHang() {
        return sl_donHang;
    }

    public void setSl_donHang(int sl_donHang) {
        this.sl_donHang = sl_donHang;
    }

    public int getTienHang() {
        return tienHang;
    }

    public void setTienHang(int tienHang) {
        this.tienHang = tienHang;
    }

    public int getThue() {
        return thue;
    }

    public void setThue(int thue) {
        this.thue = thue;
    }

    public int getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(int doanhSo) {
        this.doanhSo = doanhSo;
    }
    
}

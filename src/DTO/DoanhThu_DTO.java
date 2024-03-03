/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DoanhThu_DTO {
    // main panel doanh thu
    private String id_cuaHang;
    private String ten_cuaHang;
    private int thang;
    private int nam;
    private int sl_online;
    private int sl_offline;
    private int doanhThu_online;
    private int doanhThu_offline;
    private int tong_doanhThu;
    private int loiNhuan;
    private String id_NhanVien;
    private String ten_NhanVien;
    // panel doanh thu theo nhan vien lay tu HOA_DON

    public DoanhThu_DTO() {
        this.id_cuaHang = "";
        this.ten_cuaHang = "";
        this.thang = 1;
        this.nam = 1;
        this.sl_offline = 0;
        this.doanhThu_offline = 0;
        this.sl_online = 0;
        this.doanhThu_online = 0;
        this.tong_doanhThu = 0;
        this.loiNhuan = 0;
    }

    public String getId_cuaHang() {
        return id_cuaHang;
    }

    public void setId_cuaHang(String id_cuaHang) {
        this.id_cuaHang = id_cuaHang;
    }

    public String getTen_cuaHang() {
        return ten_cuaHang;
    }

    public void setTen_cuaHang(String ten_cuaHang) {
        this.ten_cuaHang = ten_cuaHang;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSl_online() {
        return sl_online;
    }

    public void setSl_online(int sl_online) {
        this.sl_online = sl_online;
    }

    public int getSl_offline() {
        return sl_offline;
    }

    public void setSl_offline(int sl_offline) {
        this.sl_offline = sl_offline;
    }

    public int getDoanhThu_online() {
        return doanhThu_online;
    }

    public void setDoanhThu_online(int doanhThu_online) {
        this.doanhThu_online = doanhThu_online;
    }

    public int getDoanhThu_offline() {
        return doanhThu_offline;
    }

    public void setDoanhThu_offline(int doanhThu_offline) {
        this.doanhThu_offline = doanhThu_offline;
    }

    public int getTong_doanhThu() {
        return tong_doanhThu;
    }

    public void setTong_doanhThu(int tong_doanhThu) {
        this.tong_doanhThu = tong_doanhThu;
    }

    public int getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(int loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public String getTen_NhanVien() {
        return ten_NhanVien;
    }

    public void setTen_NhanVien(String ten_NhanVien) {
        this.ten_NhanVien = ten_NhanVien;
    }

    public String getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(String id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
    }
    
}

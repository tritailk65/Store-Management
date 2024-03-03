/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class HoaDon_DTO {
    private String id_hoadon;
    private String id_cuahang;
    private String ngaylap;
    private String id_nhanvien;
    private String id_khachhang;
    private String mota;

    public HoaDon_DTO() {
        
    }
    
    public HoaDon_DTO(String id_hoadon, String id_cuahang, String ngaylap, String id_nhanvien,String id_khachhang, String mota){
        this.id_cuahang = id_cuahang;
        this.id_hoadon = id_hoadon;
        this.ngaylap = ngaylap;
        this.id_nhanvien = id_nhanvien;
        this.id_khachhang = id_khachhang;
        this.mota = mota;
    }

    public String getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(String id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public String getId_cuahang() {
        return id_cuahang;
    }

    public void setId_cuahang(String id_cuahang) {
        this.id_cuahang = id_cuahang;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(String id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public String getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public HoaDon_DTO(String mota) {
        this.mota = mota;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    
}

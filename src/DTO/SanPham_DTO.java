/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class SanPham_DTO extends NhaCungCap_DTO{
    private String maSP;
    private String tenSP;
    private String moTa;
    private String thuocTinh;
    private double gia;

    public SanPham_DTO() {
    }

    public SanPham_DTO(String maSP, String tenSP, String moTa, String thuocTinh, double gia, String maNC, String tenNC, String sdt, String diachi) {
        super(maNC, tenNC, sdt, diachi);
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.thuocTinh = thuocTinh;
        this.gia = gia;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThuocTinh() {
        return thuocTinh;
    }

    public void setThuocTinh(String thuocTinh) {
        this.thuocTinh = thuocTinh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    
}

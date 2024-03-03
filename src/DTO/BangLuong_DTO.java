/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */
public class BangLuong_DTO extends NhanVien_DTO{
    private int thang;
    private int nam;
    private int soNgayCong;
    private double phuCapAnUong;
    private double phuCapXang;
    private double tienThuong;
    private String moTaTienThuong;
    private double baoHiem;
    private double thue;
    private double khauTruKhac;
    private String moTaKhauTru;
    private double luongDuocLanh;
    private double tamUng;
    private String thoiGianTamUng;
    private double luongThucNhan;
    private String thoiGianNhan;
    private double luongcoban;

    public BangLuong_DTO() {
    }

    public BangLuong_DTO(int thang, int nam, int soNgayCong, double phuCapAnUong, double phuCapXang, double tienThuong, String moTaTienThuong, double baoHiem, double thue, double khauTruKhac, String moTaKhauTru, double luongDuocLanh, double tamUng, String thoiGianTamUng, double luongThucNhan, String thoiGianNhan, double luongcoban, String maNV, String maCH, String hoTen, String diaChi, String sdt, String gioiTinh, String ngaySinh, String CMCN_CCCD, String queQuan, String hocVan, String kyNang, String kinhNghiem, String chucVu, double luongCoBan, String danhGiaCuaKhachHang, int soLuongDanhGia) {
        super(maNV, maCH, hoTen, diaChi, sdt, gioiTinh, ngaySinh, CMCN_CCCD, queQuan, hocVan, kyNang, kinhNghiem, chucVu, luongCoBan, danhGiaCuaKhachHang, soLuongDanhGia);
        this.thang = thang;
        this.nam = nam;
        this.soNgayCong = soNgayCong;
        this.phuCapAnUong = phuCapAnUong;
        this.phuCapXang = phuCapXang;
        this.tienThuong = tienThuong;
        this.moTaTienThuong = moTaTienThuong;
        this.baoHiem = baoHiem;
        this.thue = thue;
        this.khauTruKhac = khauTruKhac;
        this.moTaKhauTru = moTaKhauTru;
        this.luongDuocLanh = luongDuocLanh;
        this.tamUng = tamUng;
        this.thoiGianTamUng = thoiGianTamUng;
        this.luongThucNhan = luongThucNhan;
        this.thoiGianNhan = thoiGianNhan;
        this.luongcoban = luongcoban;
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

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public double getPhuCapAnUong() {
        return phuCapAnUong;
    }

    public void setPhuCapAnUong(double phuCapAnUong) {
        this.phuCapAnUong = phuCapAnUong;
    }

    public double getPhuCapXang() {
        return phuCapXang;
    }

    public void setPhuCapXang(double phuCapXang) {
        this.phuCapXang = phuCapXang;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public String getMoTaTienThuong() {
        return moTaTienThuong;
    }

    public void setMoTaTienThuong(String moTaTienThuong) {
        this.moTaTienThuong = moTaTienThuong;
    }

    public double getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(double baoHiem) {
        this.baoHiem = baoHiem;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public double getKhauTruKhac() {
        return khauTruKhac;
    }

    public void setKhauTruKhac(double khauTruKhac) {
        this.khauTruKhac = khauTruKhac;
    }

    public String getMoTaKhauTru() {
        return moTaKhauTru;
    }

    public void setMoTaKhauTru(String moTaKhauTru) {
        this.moTaKhauTru = moTaKhauTru;
    }

    public double getLuongDuocLanh() {
        return luongDuocLanh;
    }

    public double getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(double luongcoban) {
        this.luongcoban = luongcoban;
    }

    public double getTamUng() {
        return tamUng;
    }

    public void setTamUng(double tamUng) {
        this.tamUng = tamUng;
    }

    public String getThoiGianTamUng() {
        return thoiGianTamUng;
    }

    public void setThoiGianTamUng(String thoiGianTamUng) {
        this.thoiGianTamUng = thoiGianTamUng;
    }

    public double getLuongThucNhan() {
        
        return luongThucNhan;
    }

    public void setLuongDuocLanh(double luongDuocLanh) {
        this.luongDuocLanh = luongDuocLanh;
    }
    
    public void setLuongThucNhan(double luongThucNhan) {
        this.luongThucNhan = luongThucNhan;
    }
    
    public void setLuongDuocLanh() {
        if(getSoNgayCong()<23)
            this.luongDuocLanh = getLuongCoBan()*0.8 + getPhuCapAnUong() + getPhuCapXang() + getTienThuong();
        if(getSoNgayCong()>=23)
            this.luongDuocLanh = getLuongCoBan()*0.8 + getPhuCapAnUong() + getPhuCapXang() + getTienThuong();
    }

    public void setLuongThucNhan() {
        this.luongThucNhan = getLuongDuocLanh() - getThue() - getBaoHiem() - getKhauTruKhac();
    }

    public String getThoiGianNhan() {
        return thoiGianNhan;
    }

    public void setThoiGianNhan(String thoiGianNhan) {
        this.thoiGianNhan = thoiGianNhan;
    }
}

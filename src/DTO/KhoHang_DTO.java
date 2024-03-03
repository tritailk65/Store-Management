/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author haile
 */
public class KhoHang_DTO extends SanPham_DTO{
    private String size;
    private int SL;
    private String TGCapNhat;

    public KhoHang_DTO(){
    }

    public KhoHang_DTO(String size, int SL, String TGCapNhat, String maSP, String tenSP, String moTa, String thuocTinh, double gia, String maNC, String tenNC, String sdt, String diachi) {
        super(maSP, tenSP, moTa, thuocTinh, gia, maNC, tenNC, sdt, diachi);
        this.size = size;
        this.SL = SL;
        this.TGCapNhat = TGCapNhat;
    }

    

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public String getTGCapNhat() {
        return TGCapNhat;
    }

    public void setTGCapNhat(String TGCapNhat) {
        this.TGCapNhat = TGCapNhat;
    }
    
    
}

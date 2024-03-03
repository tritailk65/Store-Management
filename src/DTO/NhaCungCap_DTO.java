/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author trita
 */

public class NhaCungCap_DTO{
    private String maNC;
    private String tenNC;
    private String sdt;
    private String diachi;

    public NhaCungCap_DTO() {
    }

    public NhaCungCap_DTO(String maNC, String tenNC, String sdt, String diachi) {
        this.maNC = maNC;
        this.tenNC = tenNC;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getTenNC() {
        return tenNC;
    }

    public void setTenNC(String tenNC) {
        this.tenNC = tenNC;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    
}

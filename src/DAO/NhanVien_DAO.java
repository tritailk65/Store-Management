/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.NhanVien_DTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author trita
 */
public class NhanVien_DAO {
    private Connection con;
    
    public boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://TRI-TAI\\SQLEXPRESS:1433;databasename=QUAN_LY_CUA_HANG_BAN_QUAN_AO;trustServerCertificate=true";
            String username = "sa";
            String password = "doanjava";
            con = DriverManager.getConnection(dbUrl,username,password);
            return true;
        } catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public void closeConnection(){
        try{
            if(con!=null){
                con.close();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<NhanVien_DTO> getAllNhanVien(){
        ArrayList<NhanVien_DTO> arr = new ArrayList<>();
        if(openConnection()){
            try{
                String sql1 = "SELECT * FROM NHAN_VIEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql1);
                while(rs.next()){
                    NhanVien_DTO nv = new NhanVien_DTO();
                    nv.setMaNV(rs.getString(1));
                    nv.setMaCH(rs.getString(2));
                    nv.setHoTen(rs.getString(3));
                    nv.setDiaChi(rs.getString(4));
                    nv.setSdt(rs.getString(5));
                    nv.setGioiTinh(rs.getString(6));
                    nv.setNgaySinh(rs.getString(7));
                    nv.setCMCN_CCCD(rs.getString(8));
                    nv.setQueQuan(rs.getString(9));
                    nv.setHocVan(rs.getString(10));
                    nv.setKyNang(rs.getString(11));
                    nv.setKinhNghiem(rs.getString(12));           
                    nv.setChucVu(rs.getString(13));                   
                    nv.setLuongCoBan(Double.parseDouble(rs.getString(14)));
                    nv.setDanhGiaCuaKhachHang(rs.getString(15));
                    nv.setSoLuongDanhGia(Integer.parseInt(rs.getString(16)));
                    arr.add(nv);                 
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public boolean delNhanVien(NhanVien_DTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "DELETE FROM NHAN_VIEN WHERE ID_NHANVIEN = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,nv.getMaNV());
                if(stmt.executeUpdate()==1)
                    result = true;
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean editNhanVien(NhanVien_DTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "UPDATE NHAN_VIEN SET ID_CUAHANG=?,HOTEN=?,DIACHI=?,SDT=?,GIOITINH=?,NGAYSINH=?,CCCD_CMND=?,QUEQUAN=?,HOCVAN=?,KYNANG=?,KINHNGHIEMLAMVIEC=?,CHUCVU=?,LUONGCOBAN=?,DANHGIACUAKHACHHANG=?,SOLUOTDANHGIA=? WHERE ID_NHANVIEN = ?";
                PreparedStatement stmt = con.prepareStatement(sql);                
                stmt.setString(1,nv.getMaCH());
                stmt.setString(2,nv.getHoTen());
                stmt.setString(3,nv.getDiaChi());
                stmt.setString(4,nv.getSdt());
                stmt.setString(5,nv.getGioiTinh());
                stmt.setString(6,nv.getNgaySinh());
                stmt.setString(7,nv.getCMCN_CCCD());
                stmt.setString(8,nv.getQueQuan());
                stmt.setString(9,nv.getHocVan());
                stmt.setString(10,nv.getKyNang());
                stmt.setString(11,nv.getKinhNghiem());
                stmt.setString(12,nv.getChucVu());
                stmt.setDouble(13,nv.getLuongCoBan());
                stmt.setString(14,nv.getDanhGiaCuaKhachHang());
                stmt.setInt(15,nv.getSoLuongDanhGia());
                stmt.setString(16,nv.getMaNV());   
                if(stmt.executeUpdate()==1){
                    result=true;
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean addNhanVien(NhanVien_DTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO NHAN_VIEN(ID_NHANVIEN,ID_CUAHANG,HOTEN,CHUCVU,SDT,LUONGCOBAN,DANHGIACUAKHACHHANG,SOLUOTDANHGIA) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nv.getMaNV());
                stmt.setString(2, nv.getMaCH());
                stmt.setString(3, nv.getHoTen());
                stmt.setString(4, nv.getChucVu());
                stmt.setString(5, nv.getSdt());
                stmt.setDouble(6, nv.getLuongCoBan());
                stmt.setString(7, nv.getDanhGiaCuaKhachHang());
                stmt.setInt(8, nv.getSoLuongDanhGia());
                if(stmt.executeUpdate()==1)
                    result=true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
        
    public boolean hasNhanVienID(String id){
        boolean result =false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM NHAN_VIEN WHERE ID_NHANVIEN='"+id+"'";
                Statement stmt =con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result=rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}

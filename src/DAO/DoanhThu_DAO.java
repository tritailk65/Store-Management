/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.*;
import DTO.*;
import BUS.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class DoanhThu_DAO {
    private Connection con;
    HoaDon_BUS hdBUS = new HoaDon_BUS();
    CuaHang_BUS chBUS = new CuaHang_BUS();
    
    public boolean openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://TRI-TAI\\SQLEXPRESS:1433;DatabaseName=QUAN_LY_CUA_HANG_BAN_QUAN_AO;encrypt=true;trustServerCertificate=true;";
            String userName = "sa";
            String password = "doanjava";
            con = DriverManager.getConnection(url, userName, password);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public void closeConnection(){
        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<DoanhThu_DTO> getAllDoanhThu(){
        ArrayList<DoanhThu_DTO> arr_doanhThu = new ArrayList<>();
        if (openConnection()){
            try {
                String sql = "SELECT * FROM DOANH_THU WHERE DOANH_THU.isUpdate = 0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    DoanhThu_DTO dt = new DoanhThu_DTO();
                    dt.setId_cuaHang(rs.getString(1));
                    dt.setThang(rs.getInt(2));
                    dt.setNam(rs.getInt(3));
                    dt.setSl_online(rs.getInt(4));
                    dt.setDoanhThu_online(rs.getInt(5));
                    dt.setSl_offline(rs.getInt(6));
                    dt.setDoanhThu_offline(rs.getInt(7));
                    dt.setTong_doanhThu(rs.getInt(8));
                    dt.setLoiNhuan(rs.getInt(9));
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr_doanhThu;
    }
    
    public DoanhThu_DTO get_DoanhThu_by_month_year_idCH(int month, int year, String id_CuaHang){
        DoanhThu_DTO dt = new DoanhThu_DTO();
        if(openConnection()){
            try {
                String sql = "SELECT * FROM DOANH_THU AS DT WHERE DT.isUpdate = 0 AND DT.THANG = "+month+" AND DT.NAM = "+year+" AND DT.ID_CUAHANG = N'"+id_CuaHang+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    dt.setId_cuaHang(rs.getString(1));
                    dt.setThang(rs.getInt(2));
                    dt.setNam(rs.getInt(3));
                    dt.setSl_online(rs.getInt(4));
                    dt.setDoanhThu_online(rs.getInt(5));
                    dt.setSl_offline(rs.getInt(6));
                    dt.setDoanhThu_offline(rs.getInt(7));
                    dt.setTong_doanhThu(rs.getInt(8));
                    dt.setLoiNhuan(rs.getInt(9));
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return dt;
    }
    
    public int tinh_DoanhThu_by_month_year_idCuaHang_moTa(int month, int year, String id_CuaHang, String moTa){
        int doanhThu = 0;
        if(openConnection()){
            try {
                String query = "SELECT HD.ID_CUAHANG, SUM(CT.SOLUONG * SP.GIA) AS 'Doanh Thu' "
                                + "FROM HOA_DON AS HD, CHI_TIET_HOA_DON AS CT, SAN_PHAM AS SP "
                                + "WHERE HD.ID_HOADON = CT.ID_HOADON AND CT.ID_SANPHAM = SP.ID_SANPHAM "
                                + "AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.ID_CUAHANG = '"+id_CuaHang+"' AND HD.MO_TA = '"+moTa+"' "
                                + "GROUP BY HD.ID_CUAHANG ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    doanhThu = rs.getInt(2);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return doanhThu;
    }
    
    public int tinh_SoLuong_by_month_year_idCuaHang_moTa(int month, int year, String id_CuaHang, String moTa){
        int sl = 0;
        if(openConnection()){
            try {
                String query = "SELECT HD.ID_CUAHANG, SUM(CT.SOLUONG) AS 'So luong' "
                                + "FROM HOA_DON AS HD, CHI_TIET_HOA_DON AS CT, SAN_PHAM AS SP "
                                + "WHERE HD.ID_HOADON = CT.ID_HOADON AND CT.ID_SANPHAM = SP.ID_SANPHAM "
                                + "AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.ID_CUAHANG = '"+id_CuaHang+"' AND HD.MO_TA = '"+moTa+"' "
                                + "GROUP BY HD.ID_CUAHANG ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    sl = rs.getInt(2);  
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return sl;
    }
    
    public boolean add_DoanhThu(DoanhThu_DTO dt){ // chi can set id_cuaHang, id_nhanVien, thang, nam
        boolean result = false;
        int doanhThu_online = tinh_DoanhThu_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "ONLINE");
        int doanhThu_offline = tinh_DoanhThu_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "OFFLINE");
        int sl_online = tinh_SoLuong_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "ONLINE");
        int sl_offline = tinh_SoLuong_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "OFFLINE");
        int tongDoanhThu = doanhThu_online + doanhThu_offline;
        int tienChiTra = 0;
        int loiNhuan = tongDoanhThu - tienChiTra;
        if(openConnection()){
            try {
                String query = "INSERT INTO DOANH_THU VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, dt.getId_cuaHang());
                stmt.setInt(2, dt.getThang());
                stmt.setInt(3, dt.getNam());
                stmt.setInt(4, sl_online);
                stmt.setInt(5, doanhThu_online);
                stmt.setInt(6, sl_offline);
                stmt.setInt(7, doanhThu_offline);
                stmt.setInt(8, tongDoanhThu);
                stmt.setInt(9, loiNhuan);
                stmt.setString(10, dt.getId_NhanVien());
                stmt.setInt(11, 0);
                if(stmt.executeUpdate()==1)
                    result=true;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean update_DoanhThu(DoanhThu_DTO dt){ // chi can set id_cuaHang, id_nhanVien, thang, nam
        boolean result = false;
        int doanhThu_online = tinh_DoanhThu_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "ONLINE");
        int doanhThu_offline = tinh_DoanhThu_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "OFFLINE");
        int sl_online = tinh_SoLuong_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "ONLINE");
        int sl_offline = tinh_SoLuong_by_month_year_idCuaHang_moTa(dt.getThang(), dt.getNam(), dt.getId_cuaHang(), "OFFLINE");
        int tongDoanhThu = doanhThu_online + doanhThu_offline;
        int tienChiTra = 0;
        int loiNhuan = tongDoanhThu - tienChiTra;
        if(openConnection()){
            try {
                String query = "UPDATE DOANH_THU SET SOLUONGOFFLINE = ?, DOANHTHUOFFLINE = ?, SOLUONGONLINE = ?, DOANHTHUONLINE = ?, TONGDOANHTHU = ?, LOINHUAN = ?, ID_NV_LAP = ?, isUpdate = 0 WHERE THANG = ? AND NAM = ? AND ID_CUAHANG = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1, sl_offline);
                stmt.setInt(2, doanhThu_offline);
                stmt.setInt(3, sl_online);
                stmt.setInt(4, doanhThu_online);
                stmt.setInt(5, tongDoanhThu);
                stmt.setInt(6, loiNhuan);
                stmt.setString(7, dt.getId_NhanVien());
                stmt.setInt(8, dt.getThang());
                stmt.setInt(9, dt.getNam());
                stmt.setString(10, dt.getId_cuaHang());
                if(stmt.executeUpdate()==1)
                    result=true;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return result;
    }
    
    public int get_NamThanhLap_by_tenCuaHang(String tenCH){
        int nam = 0;
        if(openConnection()){
            try {
                String query = "SELECT YEAR(CH.THOIGIAN_THANHLAP) FROM CUA_HANG AS CH "
                                + "WHERE CH.TENCUAHANG = N'"+tenCH+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    nam = rs.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return nam;
    }
    
    public ArrayList get_cacNamKeTuNamThanhLap_by_tenCH(String tenCH){
        ArrayList arr = new ArrayList();
        java.util.Date dNow = new java.util.Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy");
        String temp = ft.format(dNow);
        int namHienTai = Integer.parseInt(temp);
        int namTL = get_NamThanhLap_by_tenCuaHang(tenCH);
        while(namHienTai >= namTL){
            arr.add(namHienTai);
            namHienTai -= 1;
        }
        return arr;
    }
    
    public ArrayList get_cacIDnhanVien_by_tenCH(String tenCH){
        ArrayList arr = new ArrayList();
        if(openConnection()){
            try {
                String query  = "SELECT NV.ID_NHANVIEN FROM CUA_HANG AS CH, NHAN_VIEN AS NV "
                                + "WHERE CH.ID_CUAHANG = NV.ID_CUAHANG AND CH.TENCUAHANG = N'"+tenCH+"' ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String id = rs.getString(1);
                    arr.add(id);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    
    public boolean is_any_HoaDon_at_this_time(int month, int year, String id_CuaHang){
        boolean result = false;
        String temp = "";
        if(openConnection()){
            try {
                String query = "SELECT HD.ID_HOADON FROM HOA_DON AS HD "
                                + "WHERE MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.ID_CUAHANG = N'"+id_CuaHang+"' ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    temp = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        if(!temp.equals("")){
            result = true;
        }
        return result;
    }
    
    
    public boolean is_any_DoanhThu_at_this_time(int month, int year, String id_CuaHang){
        boolean result = false;
        String temp = "";
        if(openConnection()){
            try {
                String query = "SELECT DT.ID_NV_LAP FROM DOANH_THU AS DT "
                                + "WHERE DT.THANG = "+month+" AND DT.NAM = "+year+" AND DT.ID_CUAHANG = N'"+id_CuaHang+"' AND DT.isUpdate = 0 ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    temp = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        if(!temp.equals("")){
            result = true;
        }
        return result;
    }
    
    public boolean is_any_DoanhThu_has_changed_at_this_time(int month, int year, String id_CuaHang){
        boolean result = false;
        String temp = "";
        if(openConnection()){
            try {
                String query = "SELECT DT.ID_NV_LAP FROM DOANH_THU AS DT "
                                + "WHERE DT.THANG = "+month+" AND DT.NAM = "+year+" AND DT.ID_CUAHANG = N'"+id_CuaHang+"' AND DT.isUpdate = 1 ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    temp = rs.getString(1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                closeConnection();
            }
        }
        if(!temp.equals("")){
            result = true;
        }
        return result;
    }  

    public boolean doanhThu_need_update(int month, int year, String id_CuaHang){
        boolean result = false;
        if (openConnection()) {
            try {
                String query = "UPDATE DOANH_THU SET isUpdate = 1 WHERE THANG = ? AND NAM = ? AND ID_CUAHANG = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, month+"");
                stmt.setString(2, year+"");
                stmt.setString(3, id_CuaHang);
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
    
    public int tinh_soLuong_by_month_year_tenSP_idCH_moTa(int month, int year, String tenSP, String id_CuaHang, String moTa){
        int sl = 0;
        if(openConnection()){
            try {
                String query = "SELECT SP.TENSP, SUM(CT.SOLUONG) AS 'So Luong' FROM SAN_PHAM AS SP, CHI_TIET_HOA_DON AS CT, HOA_DON AS HD "
                                + "WHERE HD.ID_HOADON = CT.ID_HOADON AND CT.ID_SANPHAM = SP.ID_SANPHAM AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.MO_TA = '"+moTa+"' AND SP.TENSP = N'"+tenSP+"' AND HD.ID_CUAHANG = N'"+id_CuaHang+"' "
                                + "GROUP BY SP.TENSP ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    sl = rs.getInt(2);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return sl;
    }
    
    public int tinh_doanhThu_by_month_year_tenSP_idCH_moTa(int month, int year, String tenSP, String id_CuaHang, String moTa){
        int doanhThu = 0;
        if(openConnection()){
            try {
                String query = "SELECT SP.TENSP, SUM(CT.SOLUONG*SP.GIA) AS 'DoanhThu' FROM SAN_PHAM AS SP, CHI_TIET_HOA_DON AS CT, HOA_DON AS HD "
                                + "WHERE HD.ID_HOADON = CT.ID_HOADON AND CT.ID_SANPHAM = SP.ID_SANPHAM AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.MO_TA = '"+moTa+"' AND SP.TENSP = N'"+tenSP+"' AND HD.ID_CUAHANG = N'"+id_CuaHang+"' "
                                + "GROUP BY SP.TENSP ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    doanhThu = rs.getInt(2);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return doanhThu;
    }
    
    public ArrayList getAll_tenSP(){
        ArrayList arr = new ArrayList();
        if(openConnection()){
            try {
                String query = "SELECT SP.TENSP FROM SAN_PHAM AS SP";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String tenSP = rs.getString(1);
                    arr.add(tenSP);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public ArrayList gettAll_idNV(){
        ArrayList arr = new ArrayList();
        if(openConnection()){
            try {
                String query = "SELECT NV.ID_NHANVIEN, NV.HOTEN FROM NHAN_VIEN AS NV";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    String tenSP = rs.getString(1);
                    arr.add(tenSP);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public int tinh_SoLuongHD_by_month_year_idNV(int month, int year, String id_nv, String id_ch){
        int sl = 0;
        if(openConnection()){
            try {
                String query = "SELECT NV.ID_NHANVIEN, COUNT(HD.ID_HOADON) AS 'So luong hd' "
                                + "FROM NHAN_VIEN AS NV, HOA_DON AS HD, CHI_TIET_HOA_DON AS CT "
                                + "WHERE NV.ID_NHANVIEN = HD.ID_NHANVIEN AND HD.ID_HOADON = CT.ID_HOADON AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.ID_NHANVIEN = N'"+id_nv+"' AND HD.ID_CUAHANG = N'"+id_ch+"' "
                                + "GROUP BY NV.ID_NHANVIEN ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    sl = rs.getInt(2);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return sl;
    }
    
    public int tinh_doanhSo_by_month_year_idNV(int month, int year, String id_nv, String id_ch){
        int doanhThu = 0;
        if(openConnection()){
            try {
                String query = "SELECT NV.ID_NHANVIEN, SUM(CT.SOLUONG * SP.GIA) AS 'Doanh Thu' "
                                + "FROM NHAN_VIEN AS NV, HOA_DON AS HD, CHI_TIET_HOA_DON AS CT, SAN_PHAM AS SP "
                                + "WHERE NV.ID_NHANVIEN = HD.ID_NHANVIEN AND HD.ID_HOADON = CT.ID_HOADON AND CT.ID_SANPHAM = SP.ID_SANPHAM AND MONTH(HD.NGAYLAP) = "+month+" AND YEAR(HD.NGAYLAP) = "+year+" AND HD.ID_NHANVIEN = N'"+id_nv+"' AND HD.ID_CUAHANG = N'"+id_ch+"'  "
                                + "GROUP BY NV.ID_NHANVIEN ";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    doanhThu = rs.getInt(2);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return doanhThu;
    }
}

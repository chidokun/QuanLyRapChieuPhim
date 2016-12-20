/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;

public class PhimModel {
	public static ArrayList<Phim> traCuu(String TenPhim, Date TuNgay, Date DenNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuPhim", TenPhim, TuNgay, DenNgay);

		ArrayList<Phim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Phim(rs.getString("MaPhim"), rs.getString("TenPhim"), rs.getInt("ThoiLuong"),
					rs.getString("TenNhaSX"), rs.getInt("NamSX"), rs.getString("TenNgonNgu"),
					rs.getDate("NgayKhoiChieu"), rs.getString("TomTat"), rs.getString("TenNuocSX"),
					rs.getInt("GioiHanTuoi"), rs.getDouble("DoanhThu"), rs.getString("CacDienVien"),
					rs.getInt("TrangThai")));
		}

		return arr;
	}

	public static Phim layThongTin(String maPhim) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_Phim", maPhim);

		rs.next();
		Phim p = new Phim(maPhim, rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
				rs.getDate(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10), rs.getString(11),
				rs.getInt(12));
		Database.connect().close();
		return p;
	}

	/*
	 * public static boolean sua(NhanVien nv) {
	 * 
	 * return false; }
	 */

	public static String hienMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_Phim (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}

	public static boolean them(Phim p, ArrayList<SuatPhim> aSuatPhim) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_ThemPhim", p.getMaPhim(), p.getTenPhim(), p.getThoiLuong(), p.getMaNhaSX(),
					p.getNamSX(), p.getMaNgonNgu(), p.getNgayKhoiChieu(), p.getTomTat(), p.getMaNuocSX(),
					p.getGioiHanTuoi(), p.getCacDienVien());
			for (SuatPhim sp : aSuatPhim) {
				Database.callStoredUpdate("sp_ThemSuatPhim", sp.getMaPhim(), sp.getMaDinhDang(), sp.getMaHinhThuc(),
						sp.getMaNgonNgu());
			}
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}

	public static boolean sua(Phim p) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_SuaPhim", p.getMaPhim(), p.getTenPhim(), p.getThoiLuong(), p.getMaNhaSX(),
					p.getNamSX(), p.getMaNgonNgu(), p.getNgayKhoiChieu(), p.getTomTat(), p.getMaNuocSX(),
					p.getGioiHanTuoi(), p.getCacDienVien(), p.getTrangThai());

			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}

	public static ArrayList<BaoCaoPhim> baoCaoPhim(Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_BaoCao_DoanhThuPhim", tuNgay, denNgay);

		ArrayList<BaoCaoPhim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new BaoCaoPhim(rs.getString(1), rs.getString(2), rs.getDouble(3)));
		}

		return arr;
	}
	
	public static ArrayList<Phim> taiTatCa_phimdangchieu() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_Phim", (Object[]) null);
		
		ArrayList<Phim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Phim(rs.getString(1),rs.getString(2)));
		}

		return arr;
	}
	
}

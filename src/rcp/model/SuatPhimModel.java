package rcp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.NhanVien;
import rcp.entity.Phim;
import rcp.entity.SuatPhim;
import rcp.entity.TaiKhoan;
import rcp.util.Database;

public class SuatPhimModel {
	public static ArrayList<SuatPhim> taiDanhSach(String maPhim) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_SuatPhim",maPhim);

		ArrayList<SuatPhim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new SuatPhim(rs.getString(1),maPhim,rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return arr;
	}
	public static boolean them(SuatPhim sp) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_ThemSuatPhim",sp.getMaPhim(),sp.getMaDinhDang(),sp.getMaHinhThuc(),sp.getMaNgonNgu());
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}
	public static boolean xoa(String maSP) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_XoaSuatPhim",maSP);
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}
	

}

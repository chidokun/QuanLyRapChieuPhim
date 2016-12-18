/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.ArrayList;

import rcp.entity.*;
import rcp.util.*;

/**
 * @author Tuan
 *
 */
public class TaiKhoanModel {

	public static ArrayList<TaiKhoan> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_TaiKhoan", (Object[]) null);

		ArrayList<TaiKhoan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}

		return arr;
	}

	public static TaiKhoan layThongTinTuMaNhanVien(String maNhanVien) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_TaiKhoanTuMaNV", maNhanVien);

		rs.next();
		return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
	}

	public static boolean them(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_ThemTaiKhoan", tk.getTenDangNhap(), tk.getMaNhanVien(),
				tk.getMaQuyen()) > 0;
	}

	public static boolean sua(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_SuaTaiKhoan", tk.getTenDangNhap(), tk.getMaQuyen(),
				tk.getTrangThai()) > 0;
	}

	public static boolean xoa(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_XoaTaiKhoan", tk.getTenDangNhap()) > 0;
	}

}

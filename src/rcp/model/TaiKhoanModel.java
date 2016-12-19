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

	/**
	 * Lấy danh sách tài khoản
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TaiKhoan> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_TaiKhoan", (Object[]) null);

		ArrayList<TaiKhoan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}

		return arr;
	}

	/**
	 * Lấy tài khoản từ mã nhân viên
	 * 
	 * @param maNhanVien
	 * @return
	 * @throws SQLException
	 */
	public static TaiKhoan layThongTinTuMaNhanVien(String maNhanVien) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_TaiKhoanTuMaNV", maNhanVien);

		rs.next();
		return new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
	}

	/**
	 * Thêm một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_ThemTaiKhoan", tk.getTenDangNhap(), tk.getMaNhanVien(),
				tk.getMaQuyen()) > 0;
	}

	/**
	 * Sửa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_SuaTaiKhoan", tk.getTenDangNhap(), tk.getMaQuyen(), tk.getTrangThai()) > 0;
	}

	/**
	 * Xóa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean xoa(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_XoaTaiKhoan", tk.getTenDangNhap()) > 0;
	}

	/**
	 * Lấy danh sách tài khoản
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TaiKhoan1> taiTatCaDS() throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_TaiKhoan", (Object[]) null);

		ArrayList<TaiKhoan1> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiKhoan1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6)));
		}

		return arr;
	}

	/**
	 * Đặt lại mật khẩu cho một tài khoản
	 */
	public static boolean datLaiMatKhau(TaiKhoan tk) throws SQLException {
		return Database.callStoredUpdate("sp_DatLaiMatKhau", tk.getTenDangNhap()) > 0;
	}

}

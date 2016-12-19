/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.TaiKhoan;
import rcp.model.TaiKhoanModel;

/**
 * @author Tuan
 *
 */
public class TaiKhoanController {

	/**
	 * Lấy danh sách tài khoản
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TaiKhoan> taiTatCa() throws SQLException {
		return TaiKhoanModel.taiTatCa();
	}

	/**
	 * Lấy tài khoản từ mã nhân viên
	 * 
	 * @param maNhanVien
	 * @return
	 * @throws SQLException
	 */
	public static TaiKhoan layThongTinTuMaNhanVien(String maNhanVien) throws SQLException {
		return TaiKhoanModel.layThongTinTuMaNhanVien(maNhanVien);
	}

	/**
	 * Thêm một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.them(tk);
	}

	/**
	 * Sửa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.sua(tk);
	}

	/**
	 * Xóa một tài khoản
	 * 
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean xoa(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.xoa(tk);
	}
}

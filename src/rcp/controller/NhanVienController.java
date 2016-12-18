/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.*;
import java.util.*;
import rcp.entity.*;
import rcp.model.*;

/**
 * @author Tuan
 *
 */
public class NhanVienController {
	/**
	 * Lấy tất cả nhân viên
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhanVien> taiTatCa() throws SQLException {
		return NhanVienModel.taiTatCa();
	}

	/**
	 * Lấy thông tin một nhân viên
	 * 
	 * @param maNhanVien
	 *            Mã nhân viên
	 * @return
	 * @throws SQLException
	 */
	public static NhanVien layThongTin(String maNhanVien) throws SQLException {
		return NhanVienModel.layThongTin(maNhanVien);
	}

	/**
	 * Thêm một nhân viên mà không có tài khoản
	 * 
	 * @param nv
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(NhanVien nv) throws SQLException {
		return NhanVienModel.them(nv);
	}

	/**
	 * Thêm một nhân viên kèm tài khoản
	 * 
	 * @param nv
	 * @param tk
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(NhanVien nv, TaiKhoan tk) throws SQLException {
		return NhanVienModel.them(nv, tk);
	}

	/**
	 * Sửa một nhân viên mà lựa chọn xóa tài khoản hoặc không
	 * 
	 * @param nv
	 * @param xoaTaiKhoan
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(NhanVien nv, boolean xoaTaiKhoan) throws SQLException {
		return NhanVienModel.sua(nv, xoaTaiKhoan);
	}

	/**
	 * Sửa một nhân viên và thêm hoặc sửa tài khoản
	 * 
	 * @param nv
	 * @param tk
	 * @param themTaiKhoan
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(NhanVien nv, TaiKhoan tk, boolean themTaiKhoan) throws SQLException {
		return NhanVienModel.sua(nv, tk, themTaiKhoan);
	}

	/**
	 * Tra cứu nhân viên theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param tenNhanVien
	 * @param maChucVu
	 * @param CMND
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhanVien> traCuu(String tenNhanVien, String maChucVu, String CMND) throws SQLException {
		return NhanVienModel.traCuu(tenNhanVien, maChucVu, CMND);
	}

	/**
	 * Sinh mã nhân viên mới
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String taoMa() throws SQLException {
		return NhanVienModel.taoMa();
	}

	/**
	 * Kiểm tra nhân viên này có tài khoản hay chưa
	 * 
	 * @param maNhanVien
	 * @return
	 * @throws SQLException
	 */
	public static boolean coTaiKhoan(String maNhanVien) throws SQLException {
		return NhanVienModel.coTaiKhoan(maNhanVien);
	}
}

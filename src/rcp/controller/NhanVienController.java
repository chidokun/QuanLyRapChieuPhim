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
	public static ArrayList<NhanVien> taiTatCa() throws SQLException {
		return NhanVienModel.taiTatCa();
	}
	
	public static NhanVien layThongTin(String maNhanVien) throws SQLException {
		return NhanVienModel.layThongTin(maNhanVien);
	}
	
	public static boolean them(NhanVien nv) throws SQLException {
		return NhanVienModel.them(nv);
	}
	
	public static boolean them(NhanVien nv, TaiKhoan tk) throws SQLException {
		return NhanVienModel.them(nv,tk);
	}
	
	public static boolean sua(NhanVien nv, boolean xoaTaiKhoan) throws SQLException {
		return NhanVienModel.sua(nv,xoaTaiKhoan);
	}
	
	public static boolean sua(NhanVien nv, TaiKhoan tk, boolean themTaiKhoan) throws SQLException {
		return NhanVienModel.sua(nv, tk, themTaiKhoan);
	}
	
	public static ArrayList<NhanVien> traCuu(String tenNhanVien, String maChucVu, String CMND) throws SQLException {
		return NhanVienModel.traCuu(tenNhanVien, maChucVu, CMND);
	}
	
	public static String taoMa() throws SQLException {
		return NhanVienModel.taoMa();
	}
	
	public static boolean coTaiKhoan(String maNhanVien) throws SQLException {
		return NhanVienModel.coTaiKhoan(maNhanVien);
	}
}

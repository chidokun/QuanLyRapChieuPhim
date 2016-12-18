/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.*;
import java.util.*;
import rcp.entity.*;
import rcp.model.*;
import rcp.util.Database;

/**
 * @author Tuan
 *
 */
public class TaiKhoanController {
	public static ArrayList<TaiKhoan> taiTatCa() throws SQLException {
		return TaiKhoanModel.taiTatCa();		
	}
	
	public static TaiKhoan layThongTinTuMaNhanVien(String maNhanVien) throws SQLException {
		return TaiKhoanModel.layThongTinTuMaNhanVien(maNhanVien);
	}
	
	public static boolean them(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.them(tk);
	}
	
	public static boolean sua(TaiKhoan tk) throws SQLException{
		return TaiKhoanModel.sua(tk);
	}
	
	public static boolean xoa(TaiKhoan tk) throws SQLException {
		return TaiKhoanModel.xoa(tk);		
	}
}

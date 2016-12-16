/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NhanVien;
import rcp.util.Database;
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
	
	public static boolean them(NhanVien nv) {
		return NhanVienModel.them(nv);
	}
	
	public static boolean sua(NhanVien nv) {
		return NhanVienModel.sua(nv);
	}
	
	public static String taoMa() {
		return taoMa();
	}

}

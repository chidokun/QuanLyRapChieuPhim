/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.controller;

import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.entity.*;
import rcp.model.*;
import rcp.util.Database;

/**
 * @author Toàn
 *
 */
public class SuatChieuController {
	/**
	 * Lấy tất cả suất chiếu
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatChieu> taiTatCa() throws SQLException {
		return SuatChieuModel.taiTatCa();
	}

	/**
	 * Lấy thông tin một suất chiếu
	 * 
	 * @param maSuatChieu
	 *            Mã suất chiếu
	 * @return
	 * @throws SQLException
	 */
	public static SuatChieu layThongTin(String maSuatChieu) throws SQLException {
		return SuatChieuModel.layThongTin(maSuatChieu);
	}

	/**
	 * Thêm một suất chiếu
	 * 
	 * @param sc
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(SuatChieu sc) throws SQLException {
		return SuatChieuModel.them(sc);
	}

	/**
	 * Sửa suất chiếu
	 * 
	 * @param sc
	 * @return
	 * @throws SQLException
	 */
	public static boolean sua(SuatChieu sc) throws SQLException {
		return SuatChieuModel.sua(sc);
	}

	/**
	 * Tra cứu suất chiếu theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param tenPhim
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatChieu> traCuu(String tenPhim, Date tuNgay, Date denNgay) throws SQLException {
		return SuatChieuModel.traCuu(tenPhim, tuNgay, denNgay);
	}

	/**
	 * Sinh mã suất chiếu mới
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String taoMa() throws SQLException {
		return SuatChieuModel.taoMa();
	}

	/**
	 * Lấy thông tin suất phim từ mã suất chiếu
	 * 
	 * @param maSuatChieu
	 * @return
	 * @throws SQLException
	 */
	public static SuatPhim layThongTin_SuatPhim_TuSuatChieu(String maSuatChieu) throws SQLException {
		return SuatChieuModel.layThongTin_SuatPhim_TuSuatChieu(maSuatChieu);
	}
	
	/**
	 * @param maPhim
	 * @return
	 *  Lấy danh sách suất phim từ mã phim
	 */
	public static ArrayList<SuatPhim> layDanhSachSuatPhim(String maPhim) throws SQLException {
		return SuatChieuModel.layDanhSachSuatPhim(maPhim);
	}
}

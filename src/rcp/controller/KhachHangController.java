/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.BaoCaoKhachHang;
import rcp.entity.KhachHang;
import rcp.model.KhachHangModel;

/**
 * @author Vuong
 *
 */
public class KhachHangController {

	/**
	 * Lấy tất cả thông tin
	 * 
	 * @return
	 */
	public static ArrayList<KhachHang> taiTatCa() throws SQLException {
		return KhachHangModel.taiTatCa();
	}

	/**
	 * Lấy thông tin một khách hàng
	 * 
	 * @param maKhachHang
	 * @return
	 */
	public static KhachHang layThongTin(String maKhachHang) throws SQLException {
		return KhachHangModel.layThongTin(maKhachHang);
	}

	/**
	 * Tra cứu khách hàng theo tiêu chí nào đó
	 * 
	 * @param hoten
	 * @param CMND
	 * @return
	 */
	public static ArrayList<KhachHang> traCuu(String hoten, String CMND) throws SQLException {
		return KhachHangModel.traCuu(hoten, CMND);
	}

	/**
	 * Tạo mã khách hàng mới
	 * 
	 * @return
	 */
	public static String taoMa() throws SQLException {
		return KhachHangModel.taoMa();
	}

	/**
	 * Thêm một khách hàng mới
	 * 
	 * @param kh
	 * @return
	 */
	public static boolean them(KhachHang kh) throws SQLException {
		return KhachHangModel.them(kh);
	}

	/**
	 * Sửa thông tin một khách hàng
	 * 
	 * @param kh
	 * @return
	 */
	public static boolean sua(KhachHang kh) throws SQLException {
		return KhachHangModel.sua(kh);
	}
	
	/**
	 * Báo cáo khách hàng
	 * 
	 * @param loaiKH
	 *            0: cả hai loại. 1: VIP. 2: Thường
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<BaoCaoKhachHang> baoCaoKhachHang(int loaiKH, Date tuNgay, Date denNgay)
			throws SQLException {
		return KhachHangModel.baoCaoKhachHang(loaiKH, tuNgay, denNgay);
	}
}

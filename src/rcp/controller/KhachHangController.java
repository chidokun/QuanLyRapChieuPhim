/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.KhachHang;
import rcp.entity.NhanVien;
import rcp.entity.TaiKhoan;
import rcp.model.KhachHangModel;
import rcp.model.NhanVienModel;



/**
 * @author Vuong
 *
 */
public class KhachHangController {
	/**
	 * 
	 * @return
	 * Lấy tất cả thông tin
	 */
	public static ArrayList<KhachHang> taiTatCa() throws SQLException {
		return KhachHangModel.taiTatCa();
	}
	
	/**
	 * 
	 * @param maKhachHang
	 * @return
	 * Lấy thông tin một khách hàng
	 */
	public static KhachHang layThongTin(String maKhachHang) throws SQLException {
		return KhachHangModel.layThongTin(maKhachHang);
	}
	
	/**
	 * 
	 * @param hoten
	 * @param CMND
	 * @return
	 * Tra cứu khách hàng theo tiêu chí nào đó
	 */
	public static ArrayList<KhachHang> traCuu(String hoten, String CMND) throws SQLException {
		return KhachHangModel.traCuu(hoten, CMND);
	}
	
	/**
	 * 
	 * @return
	 *Tạo mã khách hàng mới
	 */
	public static String taoMa() throws SQLException {
		return KhachHangModel.taoMa();
	}
	
	/**
	 * 
	 * @param kh
	 * @return
	 *Thêm một khách hàng mới
	 */
	public static boolean them(KhachHang kh) throws SQLException {
		return KhachHangModel.them(kh);
	}
	
	/**
	 * 
	 * @param kh
	 * @return
	 * Sửa thông tin một khách hàng
	 */
	public static boolean sua(KhachHang kh) throws SQLException {
		return KhachHangModel.sua(kh);
	}
}

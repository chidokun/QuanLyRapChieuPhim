/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.ChiTietHDThucAn;
import rcp.entity.HoaDonThucAn;
import rcp.model.HoaDonModel;

/**
 * @author Toàn
 *
 */
public class HoaDonController {
	/**
	 * Lấy tất cả hóa đơn
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HoaDonThucAn> taiTatCa() throws SQLException {
		return HoaDonModel.taiTatCa();
	}

	/**
	 * Tra cứu hóa đơn theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param maHoaDon
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HoaDonThucAn> traCuu(String maHoaDon, Date tuNgay, Date denNgay) throws SQLException {
		return HoaDonModel.traCuu(maHoaDon, tuNgay, denNgay);
	}

	/**
	 * lấy chi tiết hóa đơn thức ăn
	 *
	 * @param maHoaDon
	 * 			mã hóa đơn
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ChiTietHDThucAn> layCTHoaDon(String maHoaDon) throws SQLException {
		return HoaDonModel.layCTHoaDon(maHoaDon);
	}
	/**
	 * lấy mã hóa đơn phát sinh tự động
	 *
	 * @return
	 * @throws SQLException
	 */
	public static String hienMa() throws SQLException {
		return HoaDonModel.hienMa();
	}
	/**
	 * thêm hóa đơn thức ăn
	 *
	 * @param hd, arr
	 * 			hóa đơn, danh sách chi tiết hóa đơn thức ăn
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(HoaDonThucAn hd, ArrayList<ChiTietHDThucAn> arr) throws SQLException {
		return HoaDonModel.them(hd, arr);
	}

}

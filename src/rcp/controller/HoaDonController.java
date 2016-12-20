/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.ChiTietHDThucAn;
import rcp.entity.HoaDonThucAn;
import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.model.HoaDonModel;
import rcp.model.ThucAnModel;
import rcp.util.Database;

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
	 * @param maHoaDon
	 * @return
	 *  Lấy thông tin chi tiết hóa đơn
	 */
	public static ArrayList<ChiTietHDThucAn> layCTHoaDon(String maHoaDon) throws SQLException {
		return HoaDonModel.layCTHoaDon(maHoaDon);
	}
	
}

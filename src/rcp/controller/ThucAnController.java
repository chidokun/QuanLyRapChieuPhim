/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.model.ThucAnModel;
import rcp.util.Database;

/**
 * @author Toàn
 *
 */
public class ThucAnController {
	/**
	 * 
	 * @return Lấy tất cả thông tin
	 */
	public static ArrayList<ThucAn> taiTatCa() throws SQLException {
		return ThucAnModel.taiTatCa();
	}

	/**
	 * @param maThucAn
	 * @return Lấy thông tin thức ăn kích cỡ
	 */
	public static ArrayList<ThucAnKichCo> layThongTin_TAKC(String maThucAn) throws SQLException {
		return ThucAnModel.layThongTin_TAKC(maThucAn);
	}

	/**
	 * 
	 * @param maThucAn
	 * @return Lấy thông tin thức ăn
	 */
	public static ThucAn layThongTin(String maThucAn) throws SQLException {
		return ThucAnModel.layThongTin(maThucAn);
	}

	/**
	 * 
	 * @param tenThucAn
	 * @param loaiThucAn
	 * @return Tra cứu thông tin khách hàng theo tiêu chí nào đó
	 */
	public static ArrayList<ThucAn> traCuu(String tenThucAn, String loaiThucAn) throws SQLException {
		return ThucAnModel.traCuu(tenThucAn, loaiThucAn);
	}

	/**
	 * 
	 * @return Tạo mã thức ăn
	 */
	public static String taoMa() throws SQLException {
		return ThucAnModel.taoMa();
	}

	/**
	 *
	 * @param ta
	 * @return Thêm thức ăn
	 */
	public static boolean them(ThucAn ta) throws SQLException {
		return ThucAnModel.them(ta);
	}

	/**
	 *
	 * @param ta
	 * @return Sửa thông tin thức ăn
	 */
	public static boolean sua(ThucAn ta) throws SQLException {
		return ThucAnModel.sua(ta);
	}

	/**
	 * 
	 * @param takc
	 * @return
	 * Thêm thức ăn kích cỡ
	 */
	public static boolean them(ThucAnKichCo takc) throws SQLException {
		return ThucAnModel.them(takc);
	}
	
	/**
	 * 
	 * @param takc
	 * @return
	 * xóa kích cỡ thức ăn
	 */
	public static boolean xoaKichCo(ThucAnKichCo takc) throws SQLException {
		return ThucAnModel.xoaKichCo(takc);		
	}
}

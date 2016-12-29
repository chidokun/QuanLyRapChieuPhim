/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.DinhDang;
import rcp.model.DinhDangModel;
/**
 * @author Hoang
 *
 */
public class DinhDangController {
	/**
	 * Tải tất cả định dạng
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<DinhDang> taiTatCa() throws SQLException
	{
		return DinhDangModel.taiTatCa();
	}

}

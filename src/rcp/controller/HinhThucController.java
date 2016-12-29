/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.HinhThuc;
import rcp.model.HinhThucModel;
/**
 * @author Hoang
 *
 */
public class HinhThucController {
	/**
	 * Tải tất cả hình thức
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HinhThuc> taiTatCa() throws SQLException
	{
		return HinhThucModel.taiTatCa();
	}

}

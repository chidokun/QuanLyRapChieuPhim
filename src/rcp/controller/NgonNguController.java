/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NgonNgu;
import rcp.model.NgonNguModel;
/**
 * @author Hoang
 *
 */
public class NgonNguController {
	/**
	 * Tải tất cả ngôn ngữ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NgonNgu> taiTatCa() throws SQLException
	{
		return NgonNguModel.taiTatCa();
	}

}

/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NhaSanXuat;
import rcp.model.NhaSanXuatModel;
/**
 * @author Hoang
 *
 */
public class NhaSanXuatController {
	/**
	 * Tải tất cả nhà sản xuất
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NhaSanXuat> taiTatCa() throws SQLException
	{
		return NhaSanXuatModel.taiTatCa();
	}


}

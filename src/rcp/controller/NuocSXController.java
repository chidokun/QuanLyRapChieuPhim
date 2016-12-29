/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.NuocSX;
import rcp.model.NuocSanXuatModel;
/**
 * @author Hoang
 *
 */
public class NuocSXController {
	/**
	 * Tải tất cả nước sản xuất
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<NuocSX> taiTatCa() throws SQLException
	{
		return NuocSanXuatModel.taiTatCa();
	}


}

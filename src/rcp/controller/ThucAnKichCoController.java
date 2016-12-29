/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.ThucAnKichCo;
import rcp.model.ThucAnKichCoModel;
/**
 * @author Hoang
 *
 */
public class ThucAnKichCoController {
	/**
	 * thêm vé mới
	 * 
	 * @param aVe
	 * 		danh sách vé
	 * @return
	 * @throws SQLexception
	 */
	public static ArrayList<ThucAnKichCo> traCuu(int maLoaiThucAn) throws SQLException
	{
		return ThucAnKichCoModel.traCuu(maLoaiThucAn);
	}

}

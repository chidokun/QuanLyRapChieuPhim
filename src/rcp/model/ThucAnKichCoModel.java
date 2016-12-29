/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import rcp.entity.ThucAnKichCo;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class ThucAnKichCoModel {
	/**
	 * tra cứu thức ăn kích cỡ
	 * 
	 * @param maLoaiThucAn
	 * 		mã loại thức ăn 
	 * @return
	 * @throws SQLexception
	 */
	public static ArrayList<ThucAnKichCo> traCuu(int maLoaiThucAn) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuThucAnKichCo", maLoaiThucAn);

		ArrayList<ThucAnKichCo> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ThucAnKichCo(rs.getString(1), rs.getString(2),rs.getDouble(4), rs.getString(3)));
		}

		return arr;
	}

}

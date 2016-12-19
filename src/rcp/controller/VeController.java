/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.Ve;
import rcp.model.VeModel;

public class VeController {

	/**
	 * Lấy tất cả vé
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> taiTatCa() throws SQLException {
		return VeModel.taiTatCa();
	}

	/**
	 * Lấy tra cứu vé theo tiêu chí nào đó
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> traCuu(String maVe, String maKhachHang, Date tuNgay, Date denNgay) throws SQLException {
		return VeModel.traCuu(maVe, maKhachHang, tuNgay, denNgay);
	}

}

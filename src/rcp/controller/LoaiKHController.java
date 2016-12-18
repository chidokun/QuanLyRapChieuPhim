/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.LoaiKhachHang;
import rcp.model.ChucVuModel;
import rcp.model.LoaiKhachHangModel;

public class LoaiKHController {
	public static ArrayList<LoaiKhachHang> taiTatCa() throws SQLException {
		return LoaiKhachHangModel.taiTatCa();
		
	}

}

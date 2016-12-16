/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.ChucVu;
import rcp.model.*;

/**
 * @author Tuan
 *
 */
public class ChucVuController {
	public static ArrayList<ChucVu> taiTatCa() throws SQLException {
		return ChucVuModel.taiTatCa();
		
	}

}

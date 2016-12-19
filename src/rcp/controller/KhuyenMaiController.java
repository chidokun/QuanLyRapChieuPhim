/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.*;
import java.util.*;
import rcp.entity.*;
import rcp.model.*;

/**
 * @author Tuan
 *
 */
public class KhuyenMaiController {
	
	/**
	 * Lấy danh sách khuyến mãi
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<KhuyenMai> taiTatCa() throws SQLException {
		return KhuyenMaiModel.taiTatCa();
	}
}

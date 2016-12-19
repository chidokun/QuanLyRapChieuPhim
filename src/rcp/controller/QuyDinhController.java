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
public class QuyDinhController {
	
	/**
	 * Lấy danh sách quy định
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<QuyDinh> taiTatCa() throws SQLException {
		return QuyDinhModel.taiTatCa();
	}
}

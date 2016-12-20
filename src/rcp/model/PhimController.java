/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import rcp.entity.*;
import rcp.util.*;

/**
 * @author Tuan
 *
 */
public class PhimController {

	public static ArrayList<BaoCaoPhim> baoCaoPhim(Date tuNgay, Date denNgay) throws SQLException {
		return PhimModel.baoCaoPhim(tuNgay, denNgay);
	}

}

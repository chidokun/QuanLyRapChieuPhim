/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.QuyenHan;
import rcp.model.QuyenHanModel;

/**
 * @author Tuan
 *
 */
public class QuyenHanController {
	public static ArrayList<QuyenHan> taiTatCa() throws SQLException {
		return QuyenHanModel.taiTatCa();
		
	}

}

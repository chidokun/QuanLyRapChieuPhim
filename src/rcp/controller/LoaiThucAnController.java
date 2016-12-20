/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.LoaiThucAn;
import rcp.model.*;

/**
 * @author Toàn
 *
 */
public class LoaiThucAnController {
	public static ArrayList<LoaiThucAn> taiTatCa() throws SQLException {
		return LoaiThucAnModel.taiTatCa();
		
	}

}

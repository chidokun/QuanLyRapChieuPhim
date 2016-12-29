/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.SuatPhim;
import rcp.model.SuatPhimModel;
/**
 * @author Hoang
 *
 */
public class SuatPhimController {
	/**
	 * lấy danh sách suất phim của một phim cụ thể
	 * 
	 * @param maPhim
	 *            mã phim
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatPhim> taiDanhSach(String maPhim) throws SQLException{
		return SuatPhimModel.taiDanhSach(maPhim);
		
	}
	/**
	 * thêm suất phim mới
	 * 
	 * @param sp
	 *            suất phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(SuatPhim sp) throws SQLException
	{
		return SuatPhimModel.them(sp);
	}
	/**
	 * xóa suất phim 
	 * 
	 * @param sp
	 *            mã suất phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean xoa(String maSP) throws SQLException
	{
		return SuatPhimModel.xoa(maSP);
	}


}

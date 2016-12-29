/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */
package rcp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rcp.entity.SuatPhim;
import rcp.util.Database;
/**
 * @author Hoang
 *
 */
public class SuatPhimModel {
	/**
	 * lấy danh sách suất phim của một phim cụ thể
	 * 
	 * @param maPhim
	 *            mã phim
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<SuatPhim> taiDanhSach(String maPhim) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayDanhSach_SuatPhim",maPhim);

		ArrayList<SuatPhim> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new SuatPhim(rs.getString(1),maPhim,rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		return arr;
	}
	/**
	 * thêm suất phim mới
	 * 
	 * @param sp
	 *            suất phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean them(SuatPhim sp) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_ThemSuatPhim",sp.getMaPhim(),sp.getMaDinhDang(),sp.getMaHinhThuc(),sp.getMaNgonNgu());
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}
	/**
	 * xóa suất phim 
	 * 
	 * @param sp
	 *            mã suất phim
	 * @return
	 * @throws SQLException
	 */
	public static boolean xoa(String maSP) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_XoaSuatPhim",maSP);
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			return false;
		} finally {
			con.close();
		}
	}
	

}

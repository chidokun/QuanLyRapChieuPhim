/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import rcp.entity.KhachHang;
import rcp.entity.NhanVien;
import rcp.util.Database;

/**
 * @author Vuong
 *
 */
public class KhachHangModel {
	/**
	 * 
	 * @return
	 *  Lấy tất cả khách hàng
	 */
	public static ArrayList<KhachHang> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuKhachHang", null, null);

		ArrayList<KhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6), rs.getString(7),rs.getString(8), rs.getDate(9)));
		}

		Database.connect().close();
		return arr;
	}
	
	/**
	 * Lấy thông tin một khách hàng
	 * @param maKhachHang
	 * @return
	 * @throws SQLException
	 */
	public static KhachHang layThongTin(String maKhachHang) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_KhachHang", maKhachHang);

		rs.next();
		KhachHang n = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),
				rs.getDate(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getDate(9));
		Database.connect().close();
		return n;
	}
	
	/**
	 * 
	 * @param hoten
	 * @param CMND
	 * @return
	 * Tra cứu thông tin khách hàng theo tiêu chí nào đó
	 */
	public static ArrayList<KhachHang> traCuu(String hoten, String CMND) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuKhachHang", hoten, CMND);

		ArrayList<KhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9)));
		}

		return arr;
	}
	
	/**
	 * 
	 * @param kh
	 * @return
	 * Thêm một khách hàng mới
	 */
	public static boolean them(KhachHang kh) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemKhachHang", kh.getMaKhachHang(), kh.getHoTen(), kh.getGioiTinh(),
				kh.getCMND(), kh.getNgaySinh(), kh.getEmail(), kh.getSDT()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể thêm khách hàng " + kh.getHoTen());
	}
	
	/**
	 * 
	 * @param kh
	 * @return
	 * Sửa thông tin một khách hàng
	 */
	public static boolean sua(KhachHang kh) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			
			if (Database.callStoredUpdate("sp_SuaKhachHang", kh.getMaKhachHang(), kh.getHoTen(), kh.getGioiTinh(),
					 kh.getCMND(),kh.getNgaySinh(), kh.getEmail(), kh.getSDT()) ==0) 
				throw new SQLException();
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
	 * 
	 * @return
	 * Tạo mã cho một khách hàng mới
	 */
	public static String taoMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_KhachHang (?)}");
		st.registerOutParameter(1, Types.VARCHAR);

		st.execute();
		return st.getString(1);
	}
}

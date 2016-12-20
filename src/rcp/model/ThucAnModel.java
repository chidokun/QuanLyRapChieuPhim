/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.util.Database;

/**
 * @author Toàn
 *
 */
public class ThucAnModel {
	/**
	 * 
	 * @return
	 *  Lấy tất cả thức ăn
	 */
	public static ArrayList<ThucAn> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuThucAn", null, null);

		ArrayList<ThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ThucAn(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
		}

		Database.connect().close();
		return arr;
	}
	
	/**
	 * Lấy thông tin thức ăn
	 * @param maThucAn
	 * @return
	 * @throws SQLException
	 */
	public static ThucAn layThongTin(String maThucAn) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_ThucAn", maThucAn);

		rs.next();
		ThucAn n = new ThucAn(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4));
		Database.connect().close();
		return n;
	}
	
	/**
	 * @param maThucAn
	 * @return
	 *  Lấy thông tin thức ăn kích cỡ
	 */
	public static ArrayList<ThucAnKichCo> layThongTin_TAKC(String maThucAn) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_ThucAnKichCo", maThucAn);

		ArrayList<ThucAnKichCo> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ThucAnKichCo(rs.getString(1), rs.getDouble(2)));
		}

		Database.connect().close();
		return arr;
	}
	
	
	/**
	 * 
	 * @param tenThucAn
	 * @param loaiThucAn
	 * @return
	 * Tra cứu thông tin thức ăn theo tiêu chí nào đó
	 */
	public static ArrayList<ThucAn> traCuu(String tenThucAn, String loaiThucAn) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuThucAn", tenThucAn, loaiThucAn);

		ArrayList<ThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ThucAn(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}

		return arr;
	}
	
	/**
	 * 
	 * @param ta
	 * @return
	 * Thêm thức ăn
	 */
	public static boolean them(ThucAn ta) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemThucAn", ta.getMaThucAn(), ta.getTenThucAn(),ta.getLoaiThucAn()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể thêm thức ăn mới");
	}
	
	/**
	 * 
	 * @param ta
	 * @return
	 * Sửa thông tin thức ăn
	 */
	public static boolean sua(ThucAn ta) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			
			if (Database.callStoredUpdate("sp_SuaThucAn", ta.getMaThucAn(),ta.getTenThucAn(),ta.getLoaiThucAn(),ta.getTrangThai()) ==0) 
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
	 * Tạo mã thức ăn
	 */
	public static String taoMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_ThucAn (?)}");
		st.registerOutParameter(1, Types.VARCHAR);

		st.execute();
		return st.getString(1);
	}
	
	/**
	 * 
	 * @param takc
	 * @return
	 * Thêm thức ăn kích cỡ
	 */
	public static boolean them(ThucAnKichCo takc) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemThucAnKichCo", takc.getMaThucAn(),takc.getDonGia(),takc.getKichCo()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể thêm kích cỡ thức ăn");
	}
	
	/**
	 * 
	 * @param takc
	 * @return
	 * xóa kích cỡ thức ăn
	 */
	public static boolean xoaKichCo(ThucAnKichCo takc) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			
			if (Database.callStoredUpdate("sp_XoaThucAnKichCo_TheoMaThucAnVaKichCo", takc.getMaThucAn(),takc.getKichCo()) ==0) 
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
}

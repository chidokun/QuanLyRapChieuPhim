/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.model;

import java.sql.*;
import java.util.Date;
import java.util.*;
import rcp.util.*;
import rcp.entity.*;

/**
 * @author Toàn
 *
 */
public class HoaDonModel {

	/**
	 * Lấy tất cả hóa đơn
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HoaDonThucAn> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuHoaDon", null, null, null);

		ArrayList<HoaDonThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new HoaDonThucAn(rs.getString(1), rs.getDate(2), rs.getDouble(3), rs.getString(4)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Tra cứu hóa đơn theo tiêu chí Tiêu chí nào bỏ qua thì để null
	 * 
	 * @param maHoaDon
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<HoaDonThucAn> traCuu(String maHoaDon, Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuHoaDon", maHoaDon, tuNgay, denNgay);

		ArrayList<HoaDonThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new HoaDonThucAn(rs.getString(1), rs.getDate(2), rs.getDouble(3), rs.getString(4)));
		}

		return arr;
	}

	/**
	 * @param maHoaDon
	 * @return
	 *  Lấy thông tin chi tiết hóa đơn
	 */
	public static ArrayList<ChiTietHDThucAn> layCTHoaDon(String maHoaDon) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuChiTietHoaDon", maHoaDon);

		ArrayList<ChiTietHDThucAn> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ChiTietHDThucAn(rs.getString(1), rs.getString(2),rs.getString(3)
					,rs.getDouble(4),rs.getInt(5)));
		}

		Database.connect().close();
		return arr;
	}
	public static String hienMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_HoaDon (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}
	public static boolean them(HoaDonThucAn hd, ArrayList<ChiTietHDThucAn> arr ) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);
			Database.callStoredUpdate("sp_ThemHoaDonThucAn",hd.getMaHoaDon(),hd.getMaNhanVien());
			for (ChiTietHDThucAn ct:arr) {
				Database.callStoredUpdate("sp_ThemChiTietHoaDonTA", ct.getMaHoaDon(),ct.getMaThucAnKichCo(),ct.getSoLuong());
			}
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

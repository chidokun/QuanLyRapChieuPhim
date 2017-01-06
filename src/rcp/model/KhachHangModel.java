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
import java.util.Date;

import rcp.entity.BaoCaoKhachHang;
import rcp.entity.KhachHang;
import rcp.util.Database;

/**
 * @author Vuong
 *
 */
public class KhachHangModel {

	/**
	 * Lấy tất cả khách hàng
	 * 
	 * @return
	 */
	public static ArrayList<KhachHang> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuKhachHang", null, null);

		ArrayList<KhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			KhachHang k = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
			k.setDiemTichLuy(rs.getInt(10));
			arr.add(k);
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Lấy thông tin một khách hàng
	 * 
	 * @param maKhachHang
	 * @return
	 * @throws SQLException
	 */
	public static KhachHang layThongTin(String maKhachHang) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_KhachHang", maKhachHang);

		rs.next();
		KhachHang n = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
				rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
		Database.connect().close();
		return n;
	}

	/**
	 * Tra cứu thông tin khách hàng theo tiêu chí nào đó
	 * 
	 * @param hoten
	 * @param CMND
	 * @return
	 */
	public static ArrayList<KhachHang> traCuu(String hoten, String CMND) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuKhachHang", hoten, CMND);

		ArrayList<KhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9)));
		}

		return arr;
	}

	/**
	 * Thêm một khách hàng mới
	 * 
	 * @param kh
	 * @return
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
	 * Sửa thông tin một khách hàng
	 * 
	 * @param kh
	 * @return
	 */
	public static boolean sua(KhachHang kh) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			if (Database.callStoredUpdate("sp_SuaKhachHang", kh.getMaKhachHang(), kh.getHoTen(), kh.getGioiTinh(),
					kh.getCMND(), kh.getNgaySinh(), kh.getEmail(), kh.getSDT()) == 0)
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
	 * Tạo mã cho một khách hàng mới
	 * 
	 * @return
	 */
	public static String taoMa() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_KhachHang (?)}");
		st.registerOutParameter(1, Types.VARCHAR);

		st.execute();
		return st.getString(1);
	}

	/**
	 * Báo cáo khách hàng
	 * 
	 * @param loaiKH
	 * @param tuNgay
	 * @param denNgay
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<BaoCaoKhachHang> baoCaoKhachHang(String loaiKH, Date tuNgay, Date denNgay)
			throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_BaoCao_DoanhThuKhachHang (?,?,?,?)}");
		st.registerOutParameter(4, Types.DOUBLE);
		st.setObject(1, loaiKH);
		st.setObject(2, tuNgay);
		st.setObject(3, denNgay);

		ResultSet rs = st.executeQuery();

		ArrayList<BaoCaoKhachHang> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new BaoCaoKhachHang(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4),
					rs.getDouble(5)));
		}
		arr.add(new BaoCaoKhachHang(null, null, null, null, st.getDouble(4)));

		Database.connect().close();
		return arr;
	}

	/**
	 * Cập nhật điểm tích lũy cho năm mới
	 * 
	 * @throws SQLException
	 */
	public static void capNhatDiemTichLuy() throws SQLException {
		Database.callStoredUpdate("sp_CapNhatDiemTichLuy", (Object[]) null);
	}
}

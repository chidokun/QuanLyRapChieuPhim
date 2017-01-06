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

import rcp.entity.Ve;
import rcp.util.Database;

public class VeModel {

	/**
	 * Lấy tất cả vé
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> taiTatCa() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuVe", null, null, null, null);

		ArrayList<Ve> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Ve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Tra cứu vé theo tiêu chí nào đó
	 */
	public static ArrayList<Ve> traCuu(String maVe, String maKhachHang, Date tuNgay, Date denNgay) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuVe", maVe, maKhachHang, tuNgay, denNgay);

		ArrayList<Ve> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new Ve(rs.getNString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
		}

		return arr;
	}

	/**
	 * thiết lập mã khuyến mãi cho vé
	 * 
	 * @param maKH
	 *            mã khách hàng
	 * @return
	 * @throws SQLexception
	 */
	public static String layMaKhuyenMai(String maKH) throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_ThietLapKhuyenMai_Ve (?,?)}");
		st.setObject(1, maKH);
		st.registerOutParameter(2, Types.VARCHAR);
		st.execute();
		return st.getString(2);
	}

	/**
	 * tính giá vé cho vé
	 * 
	 * @param maSuatChieu,
	 *            maGhe, maKhuyenMai mã suất chiếu, mã ghế, mã khuyến mãi
	 * @return
	 * @throws SQLexception
	 */
	public static Double tinhGiaVe(String maSuatChieu, String maGhe, String maKhuyenMai) throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TinhGiaVe_Ve (?,?,?,?)}");
		st.setObject(1, maSuatChieu);
		st.setObject(2, maGhe);
		st.setObject(3, maKhuyenMai);
		st.registerOutParameter(4, Types.DOUBLE);
		st.execute();
		return st.getDouble(4);
	}

	/**
	 * tính điểm tích lũy
	 * 
	 * @param giaVe
	 *            giá vé
	 * @return
	 * @throws SQLexception
	 */
	public static int tinhDiemTichLuy(Double giaVe) throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TinhDiemTichLuy_Ve (?,?)}");
		st.setObject(1, giaVe);
		st.registerOutParameter(2, Types.INTEGER);
		st.execute();
		return st.getInt(2);
	}

	/**
	 * thêm vé mới
	 * 
	 * @param aVe
	 *            danh sách vé
	 * @return
	 * @throws SQLexception
	 */
	public static boolean them(ArrayList<Ve> aVe) throws SQLException {
		Connection con = Database.connect();
		try {
			con.setAutoCommit(false);

			for (Ve v : aVe) {
				Database.callStoredUpdate("sp_ThemVe", v.getMaSuatChieu(), v.getMaGhe(), v.getMaNhanVien(),
						v.getGiaVe(), v.getMaKM(), v.getMaKhachHang(), v.getDiemTichLuy());
			}
			con.commit();
			return true;
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
	}

}

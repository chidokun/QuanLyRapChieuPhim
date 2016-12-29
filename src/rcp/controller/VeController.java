/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import rcp.entity.Ve;
import rcp.model.VeModel;

public class VeController {

	/**
	 * Lấy tất cả vé
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> taiTatCa() throws SQLException {
		return VeModel.taiTatCa();
	}

	/**
	 * Lấy tra cứu vé theo tiêu chí nào đó
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Ve> traCuu(String maVe, String maKhachHang, Date tuNgay, Date denNgay) throws SQLException {
		return VeModel.traCuu(maVe, maKhachHang, tuNgay, denNgay);
	}
	/**
	 * thiết lập mã khuyến mãi cho vé
	 * 
	 * @param maKH
	 * 			mã khách hàng
	 * @return
	 * @throws SQLexception
	 */
	public static String layMaKhuyenMai(String maKH) throws SQLException {
		return VeModel.layMaKhuyenMai(maKH);
	}
	/**
	 * tính giá vé cho vé
	 * 
	 * @param maSuatChieu, maGhe, maKhuyenMai
	 * 		mã suất chiếu, mã ghế, mã khuyến mãi
	 * @return
	 * @throws SQLexception
	 */
	public static Double tinhGiaVe(String maSC,String maGhe, String maKM) throws SQLException {
		return VeModel.tinhGiaVe(maSC, maGhe, maKM);
	}
	/**
	 * tính điểm tích lũy
	 * 
	 * @param giaVe
	 * 		giá vé
	 * @return
	 * @throws SQLexception
	 */
	public static int tinhDiemTichLuy(Double giaVe) throws SQLException {
		return VeModel.tinhDiemTichLuy(giaVe);
	}
	/**
	 * thêm vé mới
	 * 
	 * @param aVe
	 * 		danh sách vé
	 * @return
	 * @throws SQLexception
	 */
	public static boolean them(ArrayList<Ve> aVe) throws SQLException {
		return VeModel.them(aVe);
	}	
	

}

/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

import java.util.*;

/**
 * @author Toàn
 *
 */
public class SuatChieu {
	private String	 maSuatChieu;
	private Date	 thoiGianChieu;
	private String	 maSuatPhim;
	private String	 maPhong;
	private int 	 trangThai;

	public SuatChieu() {
		// do nothing
	}

	public SuatChieu(String maSuatChieu,Date thoiGianChieu, String maSuatPhim, String maPhong, int trangThai){
		setMaSuatChieu(maSuatChieu);
		setThoiGianChieu(thoiGianChieu);
		setMaSuatPhim(maSuatPhim);
		setMaPhong(maPhong);
		setTrangThai(trangThai);
	}

	public String getMaSuatChieu() {
		return maSuatChieu;
	}

	public void setMaSuatChieu(String maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}

	public Date getThoiGianChieu() {
		return thoiGianChieu;
	}

	public void setThoiGianChieu(Date thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}

	public String getMaSuatPhim() {
		return maSuatPhim;
	}

	public void setMaSuatPhim(String maSuatPhim) {
		this.maSuatPhim = maSuatPhim;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


}

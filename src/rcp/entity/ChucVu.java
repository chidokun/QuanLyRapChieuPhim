/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

/**
 * @author Tuan
 *
 */
public class ChucVu {
	private String maChucVu;
	private String tenChucVu;
	private double luongCoBan;

	public ChucVu() {
		// do nothing
	}
	
	public ChucVu(String maChucVu, String tenChucVu, double luongCoBan) {
		setMaChucVu(maChucVu);
		setTenChucVu(tenChucVu);
		setLuongCoBan(luongCoBan);
	}

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

}
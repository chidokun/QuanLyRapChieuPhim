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
public class ThucAn {
	private String maThucAn;
	private String tenThucAn;
	private String maLoaiThucAn;
	private int trangThai;

	public ThucAn() {
		// do nothing
	}

	public ThucAn(String maThucAn, String tenThucAn, String maLoaiThucAn, int trangThai){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setMaLoaiThucAn(maLoaiThucAn);
		setTrangThai(trangThai);
	}

	public String getMaThucAn() {
		return maThucAn;
	}

	public void setMaThucAn(String maThucAn) {
		this.maThucAn = maThucAn;
	}

	public String getTenThucAn() {
		return tenThucAn;
	}

	public void setTenThucAn(String tenThucAn) {
		this.tenThucAn = tenThucAn;
	}

	public String getMaLoaiThucAn() {
		return maLoaiThucAn;
	}

	public void setMaLoaiThucAn(String maLoaiThucAn) {
		this.maLoaiThucAn = maLoaiThucAn;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


}

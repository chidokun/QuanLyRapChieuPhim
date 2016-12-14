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
public class KhuyenMai {
	private String maKM;
	private String tenKM;
	private String moTa;

	public KhuyenMai() {
		// do nothing
	}

	public KhuyenMai(String maKM, String tenKM, String moTa){
		setMaKM(maKM);
		setTenKM(tenKM);
		setMoTa(moTa);
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


}

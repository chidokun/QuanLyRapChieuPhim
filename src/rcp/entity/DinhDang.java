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
public class DinhDang {
	private String	 maDinhDang;
	private String	 tenDinhDang;
	private double	 giaDinhDang;
	


	public DinhDang() {
		// do nothing
	}

	public DinhDang(String maDinhDang,String tenDinhDang,double giaDinhDang){
		setMaDinhDang(maDinhDang);
		setTenDinhDang(tenDinhDang);
		setGiaDinhDang(giaDinhDang);

	}

	public String getMaDinhDang() {
		return maDinhDang;
	}

	public void setMaDinhDang(String maDinhDang) {
		this.maDinhDang = maDinhDang;
	}

	public String getTenDinhDang() {
		return tenDinhDang;
	}

	public void setTenDinhDang(String tenDinhDang) {
		this.tenDinhDang = tenDinhDang;
	}
	
	public double getGiaDinhDang() {
		return giaDinhDang;
	}

	public void setGiaDinhDang(double giaDinhDang) {
		this.giaDinhDang = giaDinhDang;
	}


}

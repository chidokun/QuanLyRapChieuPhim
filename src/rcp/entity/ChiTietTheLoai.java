/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

import java.util.*;

public class ChiTietTheLoai {
	private String maPhim;
	private String maTheLoai;
	
	public ChiTietTheLoai(){
		//nothing
	}
	
	public ChiTietTheLoai(String maPhim, String maTheLoai){
		setMaPhim(maPhim);
		setMaTheLoai(maTheLoai);
	}
	
	public String getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
}

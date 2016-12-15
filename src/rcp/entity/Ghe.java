/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class Ghe {
	private String maGhe;
	private String soGhe;
	private String maPhong;
	private String maLoaiGhe;
	
	public Ghe(){
		//nothing
	}
	
	public Ghe(String maGhe, String soGhe, String maPhong, String maLoaiGhe){
		setMaGhe(maGhe);
		setSoGhe(soGhe);
		setMaPhong(maPhong);
		setMaLoaiGhe(maLoaiGhe);
	}
	
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public String getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(String soGhe) {
		this.soGhe = soGhe;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaLoaiGhe() {
		return maLoaiGhe;
	}
	public void setMaLoaiGhe(String maLoaiGhe) {
		this.maLoaiGhe = maLoaiGhe;
	}
	

}

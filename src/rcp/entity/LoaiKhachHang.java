/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

import java.util.*;

public class LoaiKhachHang {
	private String maLoaiKhachHang;
	private String tenLoaiKhachHang;
	
	public LoaiKhachHang(){
		//nothing
	}
	
	public LoaiKhachHang(String maLoaiKhachHang, String tenLoaiKhachHang){
		setMaLoaiKhachHang(maLoaiKhachHang);
		setTenLoaiKhachHang(tenLoaiKhachHang);
		
	}
	
	public String getMaLoaiKhachHang() {
		return maLoaiKhachHang;
	}

	public void setMaLoaiKhachHang(String maLoaiKhachHang) {
		this.maLoaiKhachHang = maLoaiKhachHang;
	}

	public String getTenLoaiKhachHang() {
		return tenLoaiKhachHang;
	}

	public void setTenLoaiKhachHang(String tenLoaiKhachHang) {
		this.tenLoaiKhachHang = tenLoaiKhachHang;
	}

}

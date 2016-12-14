/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

import java.util.*;

public class NhaSanXuat {
	private String maNhaSX;
	private String tenNhaSX;
	
	public NhaSanXuat(){
		//nothing
	}
	
	public NhaSanXuat(String maNhaSX, String tenNhaSX){
		setMaNhaSX(maNhaSX);
		setTenNhaSX(tenNhaSX);
	}
	
	public String getMaNhaSX() {
		return maNhaSX;
	}
	public void setMaNhaSX(String maNhaSX) {
		this.maNhaSX = maNhaSX;
	}
	public String getTenNhaSX() {
		return tenNhaSX;
	}
	public void setTenNhaSX(String tenNhaSX) {
		this.tenNhaSX = tenNhaSX;
	}

}

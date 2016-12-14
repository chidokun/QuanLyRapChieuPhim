/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

import java.util.*;

public class NgonNgu {
	private String maNgonNgu;
	private String tenNgonNgu;
	
	public NgonNgu(){
		//nothing
	}
	
	public NgonNgu(String maNgonNgu, String tenNgonNgu){
		setMaNgonNgu(maNgonNgu);
		setTenNgonNgu(tenNgonNgu);
	}
	
	public String getMaNgonNgu() {
		return maNgonNgu;
	}
	public void setMaNgonNgu(String maNgonNgu) {
		this.maNgonNgu = maNgonNgu;
	}
	public String getTenNgonNgu() {
		return tenNgonNgu;
	}
	public void setTenNgonNgu(String tenNgonNgu) {
		this.tenNgonNgu = tenNgonNgu;
	}

}

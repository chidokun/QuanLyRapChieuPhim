/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.entity;

import java.util.*;

public class LoaiThucAn {
	private String maLoaiThucAn;
	private String tenLoaiThucAn;
	
	public LoaiThucAn(){
		//nothing
	}
	
	public LoaiThucAn(String maLoaiThucAn, String tenLoaiThucAn){
		setMaLoaiThucAn(maLoaiThucAn);
		setTenLoaiThucAn(tenLoaiThucAn);
	}
	
	public String getMaLoaiThucAn() {
		return maLoaiThucAn;
	}
	public void setMaLoaiThucAn(String maLoaiThucAn) {
		this.maLoaiThucAn = maLoaiThucAn;
	}
	public String getTenLoaiThucAn() {
		return tenLoaiThucAn;
	}
	public void setTenLoaiThucAn(String tenLoaiThucAn) {
		this.tenLoaiThucAn = tenLoaiThucAn;
	}
	
	
}

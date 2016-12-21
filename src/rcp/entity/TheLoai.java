/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

public class TheLoai {
	private String maTheLoai;
	private String tenTheLoai;
	
	public TheLoai(){
		//nothing
	}
	
	public TheLoai(String maTheLoai, String tenTheLoai){
		setMaTheLoai(maTheLoai);
		setTenTheLoai(tenTheLoai);
	}
	
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

}

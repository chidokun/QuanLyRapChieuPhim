/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.entity;

public class QuyDinh {
	private String maQD;
	private String tenQD;
	private float giaTri;
	private String moTa;
	
	public QuyDinh(){
		//nothing
	}
	
	public QuyDinh(String maQD, String tenQD, float giaTri, String moTa){
		setMaQD(maQD);
		setTenQD(tenQD);
		setGiaTri(giaTri);
		setMoTa(moTa);
	}
	
	public String getMaQD() {
		return maQD;
	}

	public void setMaQD(String maQD) {
		this.maQD = maQD;
	}

	public String getTenQD() {
		return tenQD;
	}

	public void setTenQD(String tenQD) {
		this.tenQD = tenQD;
	}

	public float getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(float giaTri) {
		this.giaTri = giaTri;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}

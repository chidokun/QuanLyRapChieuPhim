/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.entity;

public class BaoCaoThucAn {
	private String maThucAn;
	private String tenThucAn;
	private String tenloaiThucAn;
	private double doanhThu;
	
	public BaoCaoThucAn(){
		//nothing
	}
	
	public BaoCaoThucAn(String maThucAn, String tenThucAn, String tenLoaiThucAn, double doanhThu){
		setMaThucAn(maThucAn);
		setTenThucAn(tenThucAn);
		setTenloaiThucAn(tenLoaiThucAn);
		setDoanhThu(doanhThu);
	}

	public String getMaThucAn() {
		return maThucAn;
	}

	public void setMaThucAn(String maThucAn) {
		this.maThucAn = maThucAn;
	}

	public String getTenThucAn() {
		return tenThucAn;
	}

	public void setTenThucAn(String tenThucAn) {
		this.tenThucAn = tenThucAn;
	}

	public String getTenloaiThucAn() {
		return tenloaiThucAn;
	}

	public void setTenloaiThucAn(String tenloaiThucAn) {
		this.tenloaiThucAn = tenloaiThucAn;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	
}

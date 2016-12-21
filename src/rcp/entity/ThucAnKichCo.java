/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.entity;

/**
 * @author Toàn
 *
 */
public class ThucAnKichCo {
	private String	 maThucAnKichCo;
	private String	 maThucAn;
	private double	 donGia;
	private String	 kichCo;


	public ThucAnKichCo() {
		// do nothing
	}

	public ThucAnKichCo(String maThucAnKichCo,String maThucAn,double donGia,String kichCo){
		setMaThucAnKichCo(maThucAnKichCo);
		setMaThucAn(maThucAn);
		setDonGia(donGia);
		setKichCo(kichCo);
	}
	public ThucAnKichCo(String maThucAn,double donGia,String kichCo){
		setMaThucAn(maThucAn);
		setDonGia(donGia);
		setKichCo(kichCo);
	}
	
	public ThucAnKichCo(String maThucAn,String kichCo){
		setMaThucAn(maThucAn);
		setKichCo(kichCo);
	}
	
		public ThucAnKichCo(String kichCo,double donGia){
			setKichCo(kichCo);
			setDonGia(donGia);
	}

	public String getMaThucAnKichCo() {
		return maThucAnKichCo;
	}

	public void setMaThucAnKichCo(String maThucAnKichCo) {
		this.maThucAnKichCo = maThucAnKichCo;
	}

	public String getMaThucAn() {
		return maThucAn;
	}

	public void setMaThucAn(String maThucAn) {
		this.maThucAn = maThucAn;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getKichCo() {
		return kichCo;
	}

	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}

}

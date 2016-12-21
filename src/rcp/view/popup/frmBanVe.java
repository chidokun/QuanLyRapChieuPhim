/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.KhachHangController;
import rcp.controller.PhongChieuController;
import rcp.controller.SuatChieuController;
import rcp.controller.VeController;
import rcp.entity.KhachHang;
import rcp.entity.Phim;
import rcp.entity.PhongChieu;
import rcp.entity.SuatChieu;
import rcp.entity.Ve;
import rcp.util.DateF;
import rcp.util.Message;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class frmBanVe extends Shell {
	private Text txtNhanVien;
	private Text txtMaKhachHang;
	private Text txtMaSuatChieu;
	private Text txtTenPhim;
	private Text txtSuatPhim;
	private Text txtGioChieu;
	private Text txtPhong;
	private Table tableVe;
	private Text txtTongTien;
	private Text txtKhuyenMai;
	private String maSuatChieu;
	private DateTime dateTime;
	private ArrayList<String> dsGhe;
	private Button btnKiemTra;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmBanVe(Display display, String maSuatChieu,ArrayList<String> dsGheDaChon) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		this.maSuatChieu=maSuatChieu;
		this.dsGhe=dsGheDaChon;
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Bán vé");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã nhân viên:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(23, 102, 75, 15);
		
		txtNhanVien = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtNhanVien.setBounds(109, 99, 141, 24);
		
		Label lblTnThcn = new Label(this, SWT.NONE);
		lblTnThcn.setText("Mã khách hàng");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnThcn.setBounds(275, 102, 82, 15);
		
		txtMaKhachHang = new Text(this, SWT.BORDER);
		txtMaKhachHang.setBounds(358, 99, 141, 24);
		
		Label lblnGi = new Label(this, SWT.NONE);
		lblnGi.setText("Tên phim:");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnGi.setBounds(23, 195, 75, 15);
		
		Label lblLoiThcn = new Label(this, SWT.NONE);
		lblLoiThcn.setText("Ngày bán vé:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoiThcn.setBounds(23, 150, 75, 15);
		
		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Mã suất chiếu");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(277, 150, 75, 15);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Suất phim");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(277, 196, 75, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 507, 529, 56);
		
		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				them();
			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(325, 10, 94, 33);
		btnLuu.setEnabled(false);
		
		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setText("Hủy bỏ");
		btnHuy.setBounds(425, 10, 94, 33);
		
		txtMaSuatChieu = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtMaSuatChieu.setBounds(358, 144, 141, 24);
		
		txtTenPhim = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtTenPhim.setBounds(109, 192, 141, 24);
		
		txtSuatPhim = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtSuatPhim.setBounds(358, 192, 141, 24);
		
		Label lblGiChiu = new Label(this, SWT.NONE);
		lblGiChiu.setText("Giờ chiếu:");
		lblGiChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblGiChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiChiu.setBounds(23, 245, 75, 15);
		
		txtGioChieu = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtGioChieu.setBounds(109, 242, 141, 24);
		
		Label lblPhngChiu = new Label(this, SWT.NONE);
		lblPhngChiu.setText("Phòng chiếu:");
		lblPhngChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblPhngChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPhngChiu.setBounds(277, 245, 75, 15);
		
		txtPhong = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtPhong.setBounds(358, 242, 141, 24);
		
		dateTime = new DateTime(this, SWT.BORDER| SWT.READ_ONLY);
		dateTime.setBounds(109, 144, 141, 24);
		dateTime.setEnabled(false);
		
		tableVe = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tableVe.setBounds(23, 336, 476, 165);
		tableVe.setHeaderVisible(true);
		tableVe.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(tableVe, SWT.NONE|SWT.CHECK);
		tblclmnNewColumn.setWidth(123);
		tblclmnNewColumn.setText("Ghế");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(tableVe, SWT.NONE);
		tblclmnNewColumn_1.setWidth(124);
		tblclmnNewColumn_1.setText("Giá vé");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(tableVe, SWT.NONE);
		tblclmnNewColumn_3.setWidth(158);
		tblclmnNewColumn_3.setText("Điểm tích lũy");
		
		Label lblTngTin = new Label(this, SWT.NONE);
		lblTngTin.setText("Tổng tiền:");
		lblTngTin.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTngTin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTngTin.setBounds(277, 295, 75, 15);
		
		txtTongTien = new Text(this, SWT.BORDER| SWT.READ_ONLY);
		txtTongTien.setBounds(358, 292, 141, 24);
		
		txtKhuyenMai = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		txtKhuyenMai.setBounds(109, 292, 141, 24);
		
		Label lblKhuynMi = new Label(this, SWT.NONE);
		lblKhuynMi.setText("Khuyến mãi:");
		lblKhuynMi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKhuynMi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKhuynMi.setBounds(23, 295, 75, 15);
		
		btnKiemTra = new Button(this, SWT.NONE);
		btnKiemTra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				kiemTraMaKH();
				btnLuu.setEnabled(true);
			}
		});
		btnKiemTra.setBounds(435, 55, 64, 25);
		btnKiemTra.setText("Kiểm tra");
		createContents();
		layThongTin();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Bán vé");
		setSize(535, 592);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public void layThongTin()
	{
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat localDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			SuatChieu sc=SuatChieuController.layThongTin(maSuatChieu);
			txtMaSuatChieu.setText(sc.getMaSuatChieu());
			txtTenPhim.setText(sc.getTenPhim());
			txtGioChieu.setText(localDateFormat.format(sc.getGioChieu()));
			txtPhong.setText(sc.getPhong());
			txtSuatPhim.setText(sc.getDinhDang()+" "+sc.getHinhThuc());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void kiemTraMaKH()
	{
		if(!kiemTraTonTai(txtMaKhachHang.getText())){
			Message.show("Mã khách hàng không tồn tại", "Lỗi", SWT.OK| SWT.ICON_ERROR, getShell());
			txtMaKhachHang.setText("");
		}
		else
		try {
			if(VeController.layMaKhuyenMai(txtMaKhachHang.getText())==null)
			txtKhuyenMai.setText("Không");
			else txtKhuyenMai.setText(VeController.layMaKhuyenMai(txtMaKhachHang.getText()));
			hienVe();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean kiemTraTonTai(String maKH)
	{
		ArrayList<KhachHang> arr;
		try {
			arr = KhachHangController.taiTatCa();
			for(KhachHang kh: arr)
			{
				if(kh.getMaKhachHang().equals(maKH))
					return true;
			}
			if(maKH.isEmpty())
				return true;	
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	private ArrayList<Ve> arrVe=new ArrayList<Ve>();
	private Button btnLuu;
	public void hienVe()
	{
		taoVe();
		tableVe.removeAll();
		Double tongTien=(double) 0;
		for(Ve v:arrVe)
		{
			TableItem item = new TableItem(tableVe, SWT.NONE);
			item.setText(new String[] {v.getMaGhe().substring(3, 6),String.valueOf(v.getGiaVe()),String.valueOf(v.getDiemTichLuy())});
			tongTien+=v.getGiaVe();
		}
		tableVe.select(0);
		txtTongTien.setText(String.valueOf(tongTien));	
	}
	public void taoVe()
	{
		String maPhong=layMaPhong();
		for(String ghe:dsGhe)
		{
			Ve v=new Ve();
			v.setMaNhanVien("NV001");
			v.setMaGhe(maPhong+ghe);
			v.setMaKhachHang(txtMaKhachHang.getText().equals("")?null:txtMaKhachHang.getText());
			v.setMaKM(txtKhuyenMai.getText().equals("Không")?null:txtKhuyenMai.getText());
			v.setMaSuatChieu(txtMaSuatChieu.getText());
			v.setNgayBanVe(DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay()));
			arrVe.add(v);
		}
		for(Ve v: arrVe)
		{
			try {
				v.setGiaVe(VeController.tinhGiaVe(v.getMaSuatChieu(), v.getMaGhe(), v.getMaKM()));
				v.setDiemTichLuy(VeController.tinhDiemTichLuy(v.getGiaVe()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	}
	public String layMaPhong()
	{
		ArrayList<PhongChieu> arrPC;
		try {
			arrPC = PhongChieuController.taiTatCa();
			for(PhongChieu p: arrPC)
			{
				if(p.getTenPhong().equals(txtPhong.getText()))
					return p.getMaPhong();
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void them()
	{
		for(Ve v:arrVe)
		{
			
		}
		try {
			if(VeController.them(arrVe))
			{
				Message.show("Thêm vé thành công", "Thông báo", SWT.OK |SWT.ICON_INFORMATION, getShell());
				txtMaKhachHang.setEditable(false);
				tableVe.setEnabled(false);
				btnLuu.setEnabled(false);
				btnKiemTra.setEnabled(false);			
			}
			else Message.show("Thêm vé không thành công", "Thông báo", SWT.OK |SWT.ICON_INFORMATION, getShell());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}

/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.KhachHangController;
import rcp.controller.LoaiKHController;
import rcp.entity.KhachHang;
import rcp.entity.LoaiKhachHang;
import rcp.util.DateF;
import rcp.util.Message;

public class frmThemSuaKhachHang extends Shell {
	private boolean isInsert = false;
	private KhachHang kh = null;

	private Text txtMaKhachHang;
	private Text txtHoTen;
	private Text txtCMND;
	private Text txtEmail;
	private Text txtSDT;
	private Combo cboLoaiKH;
	private Button btnNu;
	private Button btnNam;
	private DateTime dateNgaySinh;
	private DateTime dateNgayDangKy;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 * @param kh
	 * @param title
	 */
	public frmThemSuaKhachHang(Display display, String title, KhachHang kh) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setText(title);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblThmSaKhch = new Label(this, SWT.NONE);
		lblThmSaKhch.setText(title);
		lblThmSaKhch.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblThmSaKhch.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblThmSaKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaKhch.setBounds(120, 19, 197, 35);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(frmThemSuaKhachHang.class, "/rcp/view/popup/imgKhachHang_64p.png"));
		label_1.setForeground(SWTResourceManager.getColor(34, 139, 34));
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(37, 19, 64, 64);

		Label lblMKhchHng = new Label(this, SWT.NONE);
		lblMKhchHng.setText("Mã khách hàng :");
		lblMKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMKhchHng.setBounds(34, 102, 88, 15);

		Label lblHTnKhch = new Label(this, SWT.NONE);
		lblHTnKhch.setText("Họ tên :");
		lblHTnKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHTnKhch.setBounds(34, 153, 64, 15);

		txtMaKhachHang = new Text(this, SWT.BORDER);
		txtMaKhachHang.setEnabled(false);
		txtMaKhachHang.setBounds(128, 100, 197, 24);

		txtHoTen = new Text(this, SWT.BORDER);
		txtHoTen.setBounds(128, 150, 197, 24);

		txtCMND = new Text(this, SWT.BORDER);
		txtCMND.setBounds(128, 199, 197, 24);

		Label lblCmnd = new Label(this, SWT.NONE);
		lblCmnd.setText("CMND :");
		lblCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCmnd.setBounds(34, 205, 88, 15);

		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(128, 247, 197, 24);

		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("Email :");
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmail.setBounds(34, 250, 88, 15);

		btnNam = new Button(this, SWT.RADIO);
		btnNam.setSelection(true);
		btnNam.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNam.setBounds(128, 296, 90, 16);
		btnNam.setText("Nam");

		btnNu = new Button(this, SWT.RADIO);
		btnNu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNu.setBounds(235, 296, 90, 16);
		btnNu.setText("Nữ");

		Label lblNgyngK = new Label(this, SWT.NONE);
		lblNgyngK.setText("Ngày đăng ký :");
		lblNgyngK.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyngK.setBounds(357, 102, 88, 15);

		Label lblLoi = new Label(this, SWT.NONE);
		lblLoi.setText("Loại :");
		lblLoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoi.setBounds(357, 153, 88, 15);

		txtSDT = new Text(this, SWT.BORDER);
		txtSDT.setBounds(451, 247, 197, 24);

		Label lblDienThoai = new Label(this, SWT.NONE);
		lblDienThoai.setText("Điện thoại :");
		lblDienThoai.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDienThoai.setBounds(357, 250, 88, 15);

		Label lblGioiTinh = new Label(this, SWT.NONE);
		lblGioiTinh.setText("Giới tính :");
		lblGioiTinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGioiTinh.setBounds(34, 297, 55, 15);

		dateNgaySinh = new DateTime(this, SWT.BORDER | SWT.DROP_DOWN);
		dateNgaySinh.setBounds(451, 199, 197, 24);

		Label lblNgySinh = new Label(this, SWT.NONE);
		lblNgySinh.setText("Ngày sinh :");
		lblNgySinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgySinh.setBounds(356, 205, 64, 15);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(null);
		composite.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite.setBounds(0, 336, 677, 53);

		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.setImage(SWTResourceManager.getImage(frmThemSuaKhachHang.class, "/rcp/view/page/cancel_16x16.png"));
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setText("Hủy bỏ");
		btnHuy.setBounds(573, 11, 94, 33);

		Button btnLuu = new Button(composite, SWT.NONE);
		btnLuu.setImage(SWTResourceManager.getImage(frmThemSuaKhachHang.class, "/rcp/view/page/save_16x16.png"));
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu())
					close();
			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(473, 11, 94, 33);

		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		cboLoaiKH = comboViewer.getCombo();
		cboLoaiKH.setEnabled(false);
		cboLoaiKH.setBounds(451, 150, 197, 24);

		Label label = new Label(this, SWT.NONE);
		label.setText("Vui lòng nhập đầy đủ thông tin");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(120, 60, 201, 15);

		dateNgayDangKy = new DateTime(this, SWT.BORDER | SWT.DROP_DOWN);
		dateNgayDangKy.setEnabled(false);
		dateNgayDangKy.setBounds(451, 100, 197, 24);

		isInsert = kh == null;
		this.kh = kh;
		createContents();
		
		setDefaultButton(btnLuu);
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setSize(682, 418);
		hienThiGiaoDien();

	}

	/**
	 * Hàm hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienLoaiKH();

		try {
			if (isInsert) {
				txtMaKhachHang.setText(KhachHangController.taoMa());
			} else {
				txtMaKhachHang.setText(kh.getMaKhachHang());
				txtHoTen.setText(kh.getHoTen());
				dateNgaySinh.setDate(DateF.getYear(kh.getNgaySinh()), DateF.getMonth(kh.getNgaySinh()),
						DateF.getDay(kh.getNgaySinh()));
				if (kh.getGioiTinh().equals("Nam")) {
					btnNam.setSelection(true);
					btnNu.setSelection(false);
				} else {
					btnNu.setSelection(true);
					btnNam.setSelection(false);
				}
				txtCMND.setText(kh.getCMND());
				txtEmail.setText(kh.getEmail());
				txtSDT.setText(kh.getSDT());
				cboLoaiKH.setText(kh.getMaLoaiKH());
				dateNgayDangKy.setDate(DateF.getYear(kh.getNgayDangKy()), DateF.getMonth(kh.getNgayDangKy()),
						DateF.getDay(kh.getNgayDangKy()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Hàm thực hiện hành động lưu thông tin
	 */
	public boolean luu() {
		try {
			kiemTraDieuKien();
			if (isInsert) {
				if (!KhachHangController.them(layKhachHang()))
					throw new SQLException();
			} else {
				if (!KhachHangController.sua(layKhachHang()))
					throw new SQLException();
			}
			Message.show("Lưu thông tin khách hàng thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION,
					getShell());
			return true;
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể lưu thông tin khách hàng", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng khách hàng
	 */
	public KhachHang layKhachHang() {
		return new KhachHang(txtMaKhachHang.getText(), txtHoTen.getText(), btnNam.getSelection() ? "Nam" : "Nữ",
				txtCMND.getText(), DateF.toDate(dateNgaySinh.getYear(), dateNgaySinh.getMonth(), dateNgaySinh.getDay()),
				txtEmail.getText(), txtSDT.getText(), cboLoaiKH.getText(),
				DateF.toDate(dateNgayDangKy.getYear(), dateNgayDangKy.getMonth(), dateNgayDangKy.getDay()));
	}

	/**
	 * Hàm hiển thị loại khách hàng lên combobox
	 */
	public void hienLoaiKH() {
		try {
			ArrayList<LoaiKhachHang> arr = LoaiKHController.taiTatCa();

			cboLoaiKH.removeAll();
			for (LoaiKhachHang i : arr) {
				cboLoaiKH.add(i.getTenLoaiKhachHang());
				cboLoaiKH.setData(i.getTenLoaiKhachHang(), i.getMaLoaiKhachHang());
			}
			cboLoaiKH.select(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Kiểm tra các trường có được nhập đầy đủ hay không
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		if (txtHoTen.getText() == null || txtHoTen.getText().isEmpty())
			throw new ParameterValuesException("Tên khách hàng không được trống", null);
		if (txtCMND.getText() == null || txtCMND.getText().isEmpty())
			throw new ParameterValuesException("CMND không được trống", null);
		if (txtEmail.getText() == null || txtEmail.getText().isEmpty())
			throw new ParameterValuesException("Email không được trống", null);
		if (txtSDT.getText() == null || txtSDT.getText().isEmpty())
			throw new ParameterValuesException("Số điện thoại không được trống", null);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

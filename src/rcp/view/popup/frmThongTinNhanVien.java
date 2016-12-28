/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.controller.NhanVienController;
import rcp.controller.TaiKhoanController;
import rcp.entity.NhanVien;
import rcp.util.DateF;
import rcp.util.Message;

public class frmThongTinNhanVien extends Shell {
	private NhanVien nv;

	private Text txtSDT;
	private Text txtEmail;
	private Text txtDiaChi;
	private Text txtMatKhauCu;
	private Text txtMatKhauMoi;
	private Text txtMatKhauMoiAgain;
	private Label lblHoTen;
	private Label lblMaNV;
	private Label lblGioiTinh;
	private Label lblCMND;
	private Label lblNgaySinh;
	private Label lblChucVu;
	private Label lblNgayVaoLam;
	private Button btnLuu;
	private Button btnHuyBo;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmThongTinNhanVien(Display display, NhanVien nv) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");

		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thông tin nhân viên");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmThongTinNhanVien.class, "/rcp/view/popup/imgNhanVien_64p.png"));
		label_1.setBounds(30, 20, 64, 64);

		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBounds(0, 505, 576, 56);

		btnLuu = new Button(composite_1, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu())
					close();
			}
		});
		btnLuu.setImage(SWTResourceManager.getImage(frmThongTinNhanVien.class, "/rcp/view/page/save_16x16.png"));
		btnLuu.setText("Lưu");
		btnLuu.setBounds(372, 10, 94, 33);

		btnHuyBo = new Button(composite_1, SWT.NONE);
		btnHuyBo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuyBo.setImage(SWTResourceManager.getImage(frmThongTinNhanVien.class, "/rcp/view/page/cancel_16x16.png"));
		btnHuyBo.setText("Hủy bỏ");
		btnHuyBo.setBounds(472, 10, 94, 33);

		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tabFolder.setTabHeight(25);
		tabFolder.setBounds(25, 103, 526, 373);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		CTabItem tbtmThngTin = new CTabItem(tabFolder, SWT.NONE);
		tbtmThngTin.setText("   Thông tin   ");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tbtmThngTin.setControl(composite);

		Label lblSinThoi = new Label(composite, SWT.NONE);
		lblSinThoi.setBounds(20, 239, 75, 15);
		lblSinThoi.setText("Số điện thoại:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtSDT = new Text(composite, SWT.BORDER);
		txtSDT.setBounds(111, 236, 141, 24);

		Label lblEmail = new Label(composite, SWT.NONE);
		lblEmail.setBounds(272, 239, 43, 15);
		lblEmail.setText("Email:");
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtEmail = new Text(composite, SWT.BORDER);
		txtEmail.setBounds(321, 236, 178, 24);

		Label lblaCh = new Label(composite, SWT.NONE);
		lblaCh.setBounds(20, 286, 75, 15);
		lblaCh.setText("Địa chỉ:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtDiaChi = new Text(composite, SWT.BORDER);
		txtDiaChi.setBounds(111, 283, 388, 24);

		Group grpThngTinC = new Group(composite, SWT.NONE);
		grpThngTinC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpThngTinC.setText("Thông tin cơ bản:");
		grpThngTinC.setBounds(20, 22, 479, 195);

		Label lblMThcn = new Label(grpThngTinC, SWT.NONE);
		lblMThcn.setBounds(25, 72, 75, 15);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã nhân viên:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTnThcn = new Label(grpThngTinC, SWT.NONE);
		lblTnThcn.setBounds(272, 110, 75, 15);
		lblTnThcn.setText("Ngày sinh:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblnGi = new Label(grpThngTinC, SWT.NONE);
		lblnGi.setBounds(25, 110, 75, 15);
		lblnGi.setText("CMND:");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTrngThi = new Label(grpThngTinC, SWT.NONE);
		lblTrngThi.setBounds(25, 150, 75, 15);
		lblTrngThi.setText("Chức vụ");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblKchC = new Label(grpThngTinC, SWT.NONE);
		lblKchC.setBounds(272, 72, 75, 15);
		lblKchC.setText("Giới tính:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblNgyVoLm = new Label(grpThngTinC, SWT.NONE);
		lblNgyVoLm.setBounds(272, 150, 75, 15);
		lblNgyVoLm.setText("Ngày vào làm:");
		lblNgyVoLm.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgyVoLm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		lblHoTen = new Label(grpThngTinC, SWT.NONE);
		lblHoTen.setText("Bành Thị Bưởi");
		lblHoTen.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblHoTen.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblHoTen.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHoTen.setBounds(25, 29, 176, 23);

		lblMaNV = new Label(grpThngTinC, SWT.NONE);
		lblMaNV.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblMaNV.setText("<mã>");
		lblMaNV.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMaNV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMaNV.setBounds(116, 72, 75, 15);

		lblCMND = new Label(grpThngTinC, SWT.NONE);
		lblCMND.setText("<cmnd>");
		lblCMND.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblCMND.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCMND.setBounds(116, 110, 75, 15);

		lblChucVu = new Label(grpThngTinC, SWT.NONE | SWT.WRAP);
		lblChucVu.setText("<cvu>");
		lblChucVu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblChucVu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChucVu.setBounds(116, 150, 150, 35);

		lblGioiTinh = new Label(grpThngTinC, SWT.NONE);
		lblGioiTinh.setText("<gtinh>");
		lblGioiTinh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblGioiTinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGioiTinh.setBounds(366, 72, 75, 15);

		lblNgaySinh = new Label(grpThngTinC, SWT.NONE);
		lblNgaySinh.setText("<ngsinh>");
		lblNgaySinh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgaySinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgaySinh.setBounds(366, 110, 75, 15);

		lblNgayVaoLam = new Label(grpThngTinC, SWT.NONE);
		lblNgayVaoLam.setText("<ngvaolam>");
		lblNgayVaoLam.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgayVaoLam.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgayVaoLam.setBounds(366, 150, 75, 15);

		CTabItem tbtmiMtKhu = new CTabItem(tabFolder, SWT.NONE);
		tbtmiMtKhu.setText("   Đổi mật khẩu   ");

		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tbtmiMtKhu.setControl(composite_2);

		Group grpThayiMt = new Group(composite_2, SWT.NONE);
		grpThayiMt.setBounds(20, 22, 476, 172);
		grpThayiMt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpThayiMt.setText("Thay đổi mật khẩu");

		Label lblMtKhuC = new Label(grpThayiMt, SWT.NONE);
		lblMtKhuC.setBounds(28, 35, 75, 15);
		lblMtKhuC.setText("Mật khẩu cũ:");
		lblMtKhuC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMtKhuC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtMatKhauCu = new Text(grpThayiMt, SWT.BORDER | SWT.PASSWORD);
		txtMatKhauCu.setBounds(164, 35, 264, 24);

		Label lblMtKhuMi = new Label(grpThayiMt, SWT.NONE);
		lblMtKhuMi.setBounds(28, 78, 75, 15);
		lblMtKhuMi.setText("Mật khẩu mới:");
		lblMtKhuMi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMtKhuMi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtMatKhauMoi = new Text(grpThayiMt, SWT.BORDER | SWT.PASSWORD);
		txtMatKhauMoi.setBounds(164, 78, 264, 24);

		Label lblNhpLiMt = new Label(grpThayiMt, SWT.NONE);
		lblNhpLiMt.setBounds(28, 121, 130, 15);
		lblNhpLiMt.setText("Nhập lại mật khẩu mới:");
		lblNhpLiMt.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNhpLiMt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtMatKhauMoiAgain = new Text(grpThayiMt, SWT.BORDER | SWT.PASSWORD);
		txtMatKhauMoiAgain.setBounds(164, 121, 264, 24);

		Button btnDoiMatKhau = new Button(composite_2, SWT.NONE);
		btnDoiMatKhau.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doiMatKhau();
			}
		});
		btnDoiMatKhau.setText("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(351, 210, 145, 33);
		createContents();

		this.nv = nv;
		setDefaultButton(btnLuu);
		hienThiGiaoDien();
		tabFolder.setSelection(tbtmThngTin);

	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thông tin nhân viên");
		setSize(582, 589);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hiển thị giao diện chính
	 */
	public void hienThiGiaoDien() {
		lblHoTen.setText(nv.getTenNhanVien());
		lblMaNV.setText(nv.getMaNhanVien());
		lblGioiTinh.setText(nv.getGioiTinh());
		lblCMND.setText(nv.getCMND());
		lblNgaySinh.setText(DateF.toString(nv.getNgaySinh()));
		lblChucVu.setText(nv.getTenChucVu());
		lblNgayVaoLam.setText(DateF.toString(nv.getNgayVaoLam()));

		txtSDT.setText(nv.getSDT());
		txtEmail.setText(nv.getEmail());
		txtDiaChi.setText(nv.getDiaChi());
	}

	/**
	 * Kiểm tra điều kiện thông tin nhân viên
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		if (txtSDT.getText() == null || txtSDT.getText().isEmpty())
			throw new ParameterValuesException("Số điện thoại nhân viên không được trống", null);
		if (txtEmail.getText() == null || txtEmail.getText().isEmpty())
			throw new ParameterValuesException("Email nhân viên không được trống", null);
		if (txtDiaChi.getText() == null || txtDiaChi.getText().isEmpty())
			throw new ParameterValuesException("Địa chỉ nhân viên không được trống", null);
	}

	/**
	 * Lưu thông tin nhân viên
	 * 
	 * @return
	 */
	public boolean luu() {
		try {
			kiemTraDieuKien();

			nv.setSDT(txtSDT.getText());
			nv.setEmail(txtEmail.getText());
			nv.setDiaChi(txtDiaChi.getText());

			if (!NhanVienController.sua(nv, false))
				throw new SQLException();

			Message.show("Lưu thông tin nhân viên thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return true;
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể lưu thông tin nhân viên", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}

	/**
	 * Kiểm tra điều kiện đổi mật khẩu
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraDieuKienDoiMatKhau() throws ParameterValuesException {
		if (txtMatKhauCu.getText() == null || txtMatKhauCu.getText().isEmpty())
			throw new ParameterValuesException("Mật khẩu cũ không được trống", null);
		if (txtMatKhauMoi.getText() == null || txtMatKhauMoi.getText().isEmpty())
			throw new ParameterValuesException("Mật khẩu mới không được trống", null);
		if (txtMatKhauMoiAgain.getText() == null || txtMatKhauMoiAgain.getText().isEmpty())
			throw new ParameterValuesException("Vui lòng nhập lại mật khẩu mới", null);

		if (!TaiKhoanController.dangNhap(Settings.currentUser, txtMatKhauCu.getText()))
			throw new ParameterValuesException("Mật khẩu cũ không khớp", null);
		if (!txtMatKhauMoi.getText().equals(txtMatKhauMoiAgain.getText()))
			throw new ParameterValuesException("Mật khẩu mới không khớp", null);
	}

	/**
	 * Đổi mật khẩu
	 */
	public void doiMatKhau() {
		try {
			kiemTraDieuKienDoiMatKhau();

			TaiKhoanController.doiMatKhau(Settings.currentUser, txtMatKhauCu.getText(), txtMatKhauMoi.getText());

			Message.show("Đổi mật khẩu thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION, getShell());
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show(e1.getMessage(), "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}
}

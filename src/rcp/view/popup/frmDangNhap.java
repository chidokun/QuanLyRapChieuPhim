/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import java.io.IOException;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.controller.TaiKhoanController;
import rcp.util.Message;

public class frmDangNhap extends Shell {
	private Text txtTenDangNhap;
	private Text txtMatKhau;
	public static int result;
	private Button chkLuu;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 * @throws IOException
	 */
	public frmDangNhap(Display display) throws IOException {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setLayout(null);

		Label lblTnngNhp = new Label(composite, SWT.NONE);
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnngNhp.setBounds(46, 117, 89, 15);
		lblTnngNhp.setText("Tên đăng nhập:");

		Label lblMtKhu = new Label(composite, SWT.NONE);
		lblMtKhu.setText("Mật khẩu:");
		lblMtKhu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMtKhu.setBounds(46, 162, 81, 15);

		txtTenDangNhap = new Text(composite, SWT.BORDER);
		txtTenDangNhap.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtTenDangNhap.setBounds(143, 114, 218, 26);

		txtMatKhau = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtMatKhau.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtMatKhau.setBounds(143, 156, 218, 26);

		chkLuu = new Button(composite, SWT.CHECK);
		chkLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Settings.set("saveLoginName", chkLuu.getSelection());
					Settings.save();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		chkLuu.setSelection(true);
		chkLuu.setBounds(143, 194, 163, 16);
		chkLuu.setText("Lưu tên đăng nhập");
		chkLuu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite_2.setBounds(0, 238, 453, 53);
		composite_2.setLayout(null);

		Button btnThoat = new Button(composite_2, SWT.NONE);
		btnThoat.setImage(SWTResourceManager.getImage(frmDangNhap.class, "/rcp/view/page/cancel_16x16.png"));
		btnThoat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getDisplay().close();
			}
		});
		btnThoat.setBounds(349, 10, 94, 33);
		btnThoat.setText("Thoát");

		Button btnDangNhap = new Button(composite_2, SWT.NONE);
		btnDangNhap.setImage(SWTResourceManager.getImage(frmDangNhap.class, "/rcp/view/popup/assignto_16x16.png"));
		btnDangNhap.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dangNhap();
			}
		});
		btnDangNhap.setBounds(249, 10, 94, 33);
		btnDangNhap.setText("Đăng nhập");

		Label label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmDangNhap.class, "/rcp/view/popup/imgDangNhap_64p.png"));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(46, 27, 64, 64);

		Label lblChoMng = new Label(composite, SWT.NONE);
		lblChoMng.setText("Đăng nhập");
		lblChoMng.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblChoMng.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblChoMng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChoMng.setBounds(127, 27, 176, 23);

		Label lblNhpTnng = new Label(composite, SWT.NONE);
		lblNhpTnng.setText(
				"Nhập tên đăng nhập và mật khẩu để đăng nhập.\r\nNếu có sự cố, vui lòng liên hệ quản trị viên.");
		lblNhpTnng.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNhpTnng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNhpTnng.setBounds(127, 52, 285, 44);
		createContents();

		setDefaultButton(btnDangNhap);
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Đăng nhập");
		setSize(459, 320);
		hienThi();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Đăng nhập vào hệ thống
	 */
	public void dangNhap() {
		try {
			kiemTraDieuKien();

			if (!TaiKhoanController.dangNhap(txtTenDangNhap.getText(), txtMatKhau.getText()))
				throw new Exception();

			result = SWT.OK;
			Settings.currentUser = txtTenDangNhap.getText();
			Settings.set("loginName", chkLuu.getSelection() ? txtTenDangNhap.getText() : "");
			Settings.save();

			close();
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e) {
			Message.show("Tên đăng nhập và mật khẩu không hợp lệ", "Đăng nhập không thành công",
					SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}

	/**
	 * Hiển thị giao diện ban đầu
	 */
	public void hienThi() {
		txtTenDangNhap.setText((String) Settings.get("loginName"));
		chkLuu.setSelection((boolean) Settings.get("saveLoginName"));
	}

	/**
	 * Kiểm tra nhập liệu đầy đủ trên giao diện
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		if (txtTenDangNhap.getText() == null || txtTenDangNhap.getText().isEmpty())
			throw new ParameterValuesException("Vui lòng nhập tên đăng nhập", null);
		if (txtMatKhau.getText() == null || txtMatKhau.getText().isEmpty())
			throw new ParameterValuesException("Vui lòng nhập mật khẩu", null);
	}
}

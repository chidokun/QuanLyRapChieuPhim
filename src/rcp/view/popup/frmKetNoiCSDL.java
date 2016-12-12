/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;
import java.util.*;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.util.*;

public class frmKetNoiCSDL extends Shell {
	private Text txtServer;
	private Text txtUser;
	private Text txtPassword;
	private Combo cboDatabase;
	public int result;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmKetNoiCSDL(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Window.center(display, this);
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE | SWT.WRAP);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 270, 29);
		lblNewLabel.setText("Nhập server, user và password sau đó bấm Kết nối trước khi chọn database");

		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Chỉnh sửa kết nối cơ sở dữ liệu");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 245, 23);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmKetNoiCSDL.class, "/rcp/view/popup/imgKetNoiCSDL_64p.png"));
		label_1.setBounds(30, 20, 64, 64);

		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Tên server:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(40, 107, 75, 15);

		txtServer = new Text(this, SWT.BORDER);
		txtServer.setBounds(131, 104, 241, 24);
		
				txtUser = new Text(this, SWT.BORDER);
				txtUser.setBounds(131, 146, 241, 24);
		
				txtPassword = new Text(this, SWT.BORDER | SWT.PASSWORD);
				txtPassword.setBounds(131, 189, 241, 24);
		
				Button btnKetNoi = new Button(this, SWT.NONE);
				btnKetNoi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							cboDatabase.removeAll();
							ArrayList<String> arr = Database.getDatabasesList(txtServer.getText(), txtUser.getText(),
									txtPassword.getText());
							for (String i : arr)
								cboDatabase.add(i);
							cboDatabase.select(0);
							cboDatabase.setEnabled(true);
							Message.show("Kết nối thành công. Vui lòng chọn database bên dưới.", "Thành công",
									SWT.ICON_INFORMATION | SWT.OK, getShell());
						} catch (ClassNotFoundException | SQLException e1) {
							Message.show("Không thể kết nối đến " + txtServer.getText() + ". Vui lòng thử lại sau.", "Lỗi",
									SWT.ICON_ERROR | SWT.OK, getShell());
						}
					}
				});
				btnKetNoi.setText("Kết nối");
				btnKetNoi.setBounds(278, 236, 94, 31);
		
				ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
				cboDatabase = comboViewer.getCombo();
				cboDatabase.setEnabled(false);
				cboDatabase.setBounds(131, 287, 241, 23);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 345, 409, 56);

		Button btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					kiemTraGiaoDien();
					String connectionString = String.format("jdbc:mysql://%1$s/%2$s?useSSL=false", txtServer.getText(),
							cboDatabase.getText());

					Settings.set("hostName", txtServer.getText());
					Settings.set("userName", txtUser.getText());
					Settings.set("password", txtPassword.getText());
					Settings.set("schemaName", cboDatabase.getText());
					Settings.set("connectionString", connectionString);

					Settings.save();
					Database.load();

					Message.show(
							"Kết nối cơ sở dữ liệu thành công. Vui lòng khởi động lại ứng dụng để thay đổi có hiệu lực.",
							"Lưu kết nối thành công", SWT.ICON_INFORMATION | SWT.OK, getShell());
					result = SWT.OK;
					close();
				} catch (Exception e1) {
					Message.show(e1.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
				}
			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(205, 10, 94, 33);

		Button btnHuyBo = new Button(composite, SWT.NONE);
		btnHuyBo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result = SWT.CANCEL;
				close();
			}
		});
		btnHuyBo.setText("Hủy bỏ");
		btnHuyBo.setBounds(305, 10, 94, 33);

		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setText("User:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setBounds(40, 149, 75, 15);

		Label lblSinThoi = new Label(this, SWT.NONE);
		lblSinThoi.setText("Password:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSinThoi.setBounds(40, 192, 75, 15);

		Label lblEmailHTr = new Label(this, SWT.NONE);
		lblEmailHTr.setText("Database:");
		lblEmailHTr.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmailHTr.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmailHTr.setBounds(40, 290, 75, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Kết nối cơ sở dữ liệu");
		setSize(415, 430);

		hienThi();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void hienThi() {
		txtServer.setText((String) Settings.get("hostName"));
		txtUser.setText((String) Settings.get("userName"));
		txtPassword.setText((String) Settings.get("password"));
		cboDatabase.setText((String) Settings.get("schemaName"));
	}

	public void kiemTraGiaoDien() throws ParameterValuesException {
		if (txtServer.getText().isEmpty() || txtServer.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ tên server", null);
		if (txtUser.getText().isEmpty() || txtUser.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ tên user", null);
		if (txtPassword.getText().isEmpty() || txtPassword.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ password", null);
		if (!cboDatabase.getEnabled())
			throw new ParameterValuesException("Vui lòng chọn database", null);
	}
}

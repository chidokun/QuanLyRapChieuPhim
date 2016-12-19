/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import rcp.*;
import rcp.util.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.core.commands.*;
import org.eclipse.swt.events.*;


public class frmThongTinRapPhim extends Shell {
	private Text txtTenRapPhim;
	private Text txtDiaChi;
	private Text txtSDT;
	private Text txtEmail;
	private Button btnLuu;
	private Button btnHuyBo;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThongTinRapPhim(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Chỉnh sửa thông tin rạp phim");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 245, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmThongTinRapPhim.class, "/rcp/view/popup/imgRapPhim_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Tên rạp phim:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(39, 103, 75, 15);
		
		txtTenRapPhim = new Text(this, SWT.BORDER);
		txtTenRapPhim.setBounds(130, 100, 241, 24);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 287, 409, 56);
		
		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					kiemTraGiaoDien();
					
					Settings.set("cinemaName", txtTenRapPhim.getText());
					Settings.set("cinemaAddr", txtDiaChi.getText());
					Settings.set("cinemaTel", txtSDT.getText());
					Settings.set("cinemaEmail", txtEmail.getText());

					Settings.save();

					Message.show(
							"Thay đổi thông tin rạp phim thành công",
							"Thành công", SWT.ICON_INFORMATION | SWT.OK, getShell());

					close();
				} catch (Exception e1) {
					Message.show(e1.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
				}
			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(205, 10, 94, 33);
		
		btnHuyBo = new Button(composite, SWT.NONE);
		btnHuyBo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuyBo.setText("Hủy bỏ");
		btnHuyBo.setBounds(305, 10, 94, 33);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setText("Địa chỉ:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setBounds(39, 145, 75, 15);
		
		txtDiaChi = new Text(this, SWT.BORDER);
		txtDiaChi.setBounds(130, 142, 241, 24);
		
		Label lblSinThoi = new Label(this, SWT.NONE);
		lblSinThoi.setText("Số điện thoại:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSinThoi.setBounds(39, 188, 75, 15);
		
		txtSDT = new Text(this, SWT.BORDER);
		txtSDT.setBounds(130, 185, 241, 24);
		
		Label lblEmailHTr = new Label(this, SWT.NONE);
		lblEmailHTr.setText("Email hỗ trợ:");
		lblEmailHTr.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmailHTr.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmailHTr.setBounds(39, 233, 75, 15);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(130, 230, 241, 24);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Chỉnh sửa thông tin rạp phim");
		setSize(415, 372);
		
		hienThi();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void hienThi() {
		txtTenRapPhim.setText((String) Settings.get("cinemaName"));
		txtDiaChi.setText((String) Settings.get("cinemaAddr"));
		txtSDT.setText((String) Settings.get("cinemaTel"));
		txtEmail.setText((String) Settings.get("cinemaEmail"));
	}
	
	public void kiemTraGiaoDien() throws ParameterValuesException {
		if (txtTenRapPhim.getText().isEmpty() || txtTenRapPhim.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ tên rạp phim", null);
		if (txtDiaChi.getText().isEmpty() || txtDiaChi.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ địa chỉ", null);
		if (txtSDT.getText().isEmpty() || txtSDT.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ số điện thoại", null);
		if (txtEmail.getText().isEmpty() || txtEmail.getText() == null)
			throw new ParameterValuesException("Vui lòng nhập đủ email", null);
	}
}

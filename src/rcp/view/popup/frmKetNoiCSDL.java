/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;
import java.util.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.util.Database;

public class frmKetNoiCSDL extends Shell {
	private Text txtServer;
	private Text txtUser;
	private Text txtPassword;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmKetNoiCSDL(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
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
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgKetNoiCSDL_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Tên server:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(40, 107, 75, 15);
		
		txtServer = new Text(this, SWT.BORDER);
		txtServer.setBounds(131, 104, 241, 24);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 345, 409, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(205, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(305, 10, 94, 33);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setText("User:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setBounds(40, 149, 75, 15);
		
		txtUser = new Text(this, SWT.BORDER);
		txtUser.setBounds(131, 146, 241, 24);
		
		Label lblSinThoi = new Label(this, SWT.NONE);
		lblSinThoi.setText("Password:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSinThoi.setBounds(40, 192, 75, 15);
		
		txtPassword = new Text(this, SWT.BORDER);
		txtPassword.setBounds(131, 189, 241, 24);
		
		Label lblEmailHTr = new Label(this, SWT.NONE);
		lblEmailHTr.setText("Database:");
		lblEmailHTr.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmailHTr.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmailHTr.setBounds(40, 290, 75, 15);
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		Combo cboDatabase = comboViewer.getCombo();
		cboDatabase.setBounds(131, 287, 241, 23);
		
		Button btnKtNi = new Button(this, SWT.NONE);
		btnKtNi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					comboViewer.getCombo().removeAll();
					
					ArrayList<String> arr = Database.getDatabasesList(Database.connectionString, "root", "root");
					for (String i : arr)
						comboViewer.getCombo().add(i);			
					comboViewer.getCombo().select(0);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					MessageDialog.openError(getShell(), "Lỗi", "Không thể kết nối đến " + txtServer.getText()+". Vui lòng thử lại sau.");			
				}
			}
		});
		btnKtNi.setText("Kết nối");
		btnKtNi.setBounds(278, 236, 94, 31);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Kết nối cơ sở dữ liệu");
		setSize(415, 430);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
